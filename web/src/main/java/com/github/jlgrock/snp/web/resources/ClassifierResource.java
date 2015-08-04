package com.github.jlgrock.snp.web.resources;

import gov.vha.isaac.logic.LogicGraph;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.MessageBodyReader;

import org.glassfish.jersey.media.multipart.FormDataBodyPart;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.apis.exceptions.ProcessingException;
import com.github.jlgrock.snp.apis.web.ProcessingServiceFactory;

/**
 * The controller for handling all classifier requests
 */
@Path("/classifier")
public class ClassifierResource {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(ClassifierResource.class);

	private final ProcessingServiceFactory processingServiceFactory;

	private final LogicGraphClassifier logicGraphClassifier;

	/**
	 * Constructor
	 *
	 * @param processingServiceFactoryIn
	 *            the marshaller that
	 * @param logicGraphClassifierIn
	 *            logic graph classifier
	 */
	@Inject
	public ClassifierResource(
			final ProcessingServiceFactory processingServiceFactoryIn,
			final LogicGraphClassifier logicGraphClassifierIn) {
		processingServiceFactory = processingServiceFactoryIn;
		logicGraphClassifier = logicGraphClassifierIn;
	}

	/**
	 * Handles posted multipart form requests for file uploads
	 *
	 * @param form
	 *            multipart form request
	 * @param identifier
	 *            (optional) the unique identifier, if applicable
	 * @return HTTP 200 if successful, HTTP 204 if no content is received
	 */
	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response postFile(final FormDataMultiPart form,
			@FormDataParam("id") final String identifier) {
		LOGGER.trace("Form data multipart: {}", form);
		LOGGER.trace("identifier: {}", identifier);

		if (form == null) {
			LOGGER.error("form is null");
			return Response.status(Response.Status.BAD_REQUEST).build();
		}

		// supports multi-file uploads
		List<FormDataBodyPart> fileParts = form.getFields("file");

		for (FormDataBodyPart filePart : fileParts) {

			// log body part header info
			if (LOGGER.isDebugEnabled()) {
				for (Entry<String, List<String>> fbHeader : filePart
						.getHeaders().entrySet()) {
					for (String fbHeaderValue : fbHeader.getValue()) {
						LOGGER.debug("Header: {} --> Value: {}",
								fbHeader.getKey(), fbHeaderValue);
					}
				}
			}

			if (filePart.getEntity() == null) {
				return Response.status(Response.Status.BAD_REQUEST).build();
			}
			LOGGER.debug("File part media type: {}", filePart.getMediaType());
			@SuppressWarnings("rawtypes")
			Map<MediaType, List<MessageBodyReader>> readers = filePart.messageBodyWorkers
					.getReaders(filePart.getMediaType());

			if (LOGGER.isDebugEnabled()) {
				for (Entry<MediaType, List<MessageBodyReader>> readerMediaType : readers
						.entrySet()) {
					for (MessageBodyReader<?> reader : readerMediaType
							.getValue()) {
						LOGGER.debug(
								"MessageBodyReader for Media Type [{}]: {}",
								readerMediaType.getKey(), reader);
					}
				}
			}

			String filePartString = filePart.getEntityAs(String.class);
			// take the media type from the html upload page
			try {
				processFile(filePartString, filePart.getMediaType(), identifier);
			} catch (ProcessingException e) {
				LOGGER.error(
						"Exception processing file (filePartString="
								+ filePartString + ", mediaType="
								+ filePart.getMediaType() + ", identifier="
								+ identifier + ")", e);
				return Response.status(Status.BAD_REQUEST).build();
			}
		}

		return Response.ok().build();
	}

	/**
	 * Returns a logic graph expression for a given nid
	 * 
	 * @param nid
	 *            native identifier to lookup the logic graph
	 * @return logic graph expression
	 */
	@GET
	@Path("{nid}")
	public Response getPce(@PathParam("nid") final int nid) {
		LOGGER.trace("getPce(nid={})", nid);

		LogicGraph logicGraph;
		try {
			logicGraph = logicGraphClassifier.getStatedTermLogicGraph(nid);
		} catch (IOException e) {
			return Response.serverError().build();
		}

		return Response.ok(logicGraph, MediaType.APPLICATION_JSON_TYPE).build();
	}

	/**
	 * Process the file, using the processingService. If either parameter is
	 * null, the file load is aborted and message is logged.
	 *
	 * @param input
	 *            the XML string to process. This cannot be null or empty.
	 * @param mediaType
	 *            the media type to process. This cannot be null.
	 */
	private void processFile(final String input, final MediaType mediaType,
			final String identifier) throws ProcessingException {
		LOGGER.trace(
				"processing file.  mediatype: {} , input (postBody): '{}'",
				mediaType, input);
		if (input == null || mediaType == null || input.trim().isEmpty()) {
			String errMsg = "Mediatype is not allowed to be null. Input is not allowed to be null or empty.";
			LOGGER.error(errMsg);
			throw new ProcessingException(errMsg);
		}
		processingServiceFactory.getService(mediaType).processInput(input,
				identifier);
	}
}
