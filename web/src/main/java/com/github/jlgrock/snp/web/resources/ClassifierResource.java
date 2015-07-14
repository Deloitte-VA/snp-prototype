package com.github.jlgrock.snp.web.resources;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.MessageBodyReader;

import org.glassfish.jersey.media.multipart.BodyPart;
import org.glassfish.jersey.media.multipart.FormDataBodyPart;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.jlgrock.snp.apis.web.ProcessingServiceFactory;
import com.github.jlgrock.snp.web.services.ClassifierQueryServiceImpl;

/**
 * The controller for handling all classifier requests
 */
@Path("/classifier")
public class ClassifierResource {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(ClassifierResource.class);

	private final ProcessingServiceFactory processingServiceFactory;

	private final ClassifierQueryServiceImpl classifierQueryServiceImpl;

	/**
	 * Constructor
	 *
	 * @param processingServiceFactoryIn
	 *            the marshaller that
	 * @param classifierQueryServiceImplIn
	 *            query the database
	 */
	@Inject
	public ClassifierResource(
			final ProcessingServiceFactory processingServiceFactoryIn,
			final ClassifierQueryServiceImpl classifierQueryServiceImplIn) {
		processingServiceFactory = processingServiceFactoryIn;
		classifierQueryServiceImpl = classifierQueryServiceImplIn;
	}

	/**
	 * Handles posted streaming Lego requests
	 *
	 * @param postBody
	 *            entity post body
	 * @return HTTP 200 if successful
	 */
	@POST
	private Response processUpload(final BodyPart body, final String postBody) {
		LOGGER.info("mimetype: {} , postBody: {}", body.getMediaType(),
				postBody);
		if (postBody == null) {
			LOGGER.error("requestBody is null");
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		processFile(postBody, body.getMediaType(), null);
		return Response.ok().build();
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
			processFile(filePartString, filePart.getMediaType(), identifier);
		}

		return Response.ok().build();
	}

	/**
	 * Process the file, using the processingService. If either parameter is
	 * null, the file load is aborted and message is logged.
	 *
	 * @param input
	 *            the XML string to process. This cannot be null.
	 * @param mediaType
	 *            the media type to process. This cannot be null.
	 */
	private void processFile(final String input, final MediaType mediaType,
			final String identifier) {
		LOGGER.trace("processing file.  mediatype: {} , postBody: {}",
				mediaType, input);
		if (input == null || mediaType == null) {
			LOGGER.error("neither mediatype nor input are allowed to be null.  Skipping file.");
		}
		processingServiceFactory.getService(mediaType).processInput(input,
				identifier);
	}
}
