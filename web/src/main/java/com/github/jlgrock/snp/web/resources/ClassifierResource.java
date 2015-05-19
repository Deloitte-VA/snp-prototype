package com.github.jlgrock.snp.web.resources;

import com.github.jlgrock.snp.core.domain.fhir.FhirEnvelope;
import com.github.jlgrock.snp.core.domain.lego.LegoEnvelope;
import com.github.jlgrock.snp.web.SnpMediaType;
import com.github.jlgrock.snp.web.SnpMediaTypeMapping;
import com.github.jlgrock.snp.web.services.PceClassifierService;
import org.glassfish.jersey.media.multipart.FormDataBodyPart;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.MessageBodyReader;
import java.io.Reader;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * The controller for handling all classifier requests
 */
@Path("/classifier")
public class ClassifierResource {

	private static final Logger LOGGER = LoggerFactory.getLogger(ClassifierResource.class);
	
	private PceClassifierService<LegoEnvelope> pceClssfrSvcLego;
	private PceClassifierService<FhirEnvelope> pceClssfrSvcFhir;

	/**
	 * Constructor
	 * @param pceClssfrSvcLegoIn PCE classifier service for LEGO
	 * @param pceClssfrSvcFhirIn PCE classifier service for FHIR
	 */
	@Inject
	public ClassifierResource(final PceClassifierService<LegoEnvelope> pceClssfrSvcLegoIn,
			final PceClassifierService<FhirEnvelope> pceClssfrSvcFhirIn) {
		pceClssfrSvcLego = pceClssfrSvcLegoIn;
		pceClssfrSvcFhir = pceClssfrSvcFhirIn;
	}
	
	/**
	 * Handles posted streaming Lego requests
	 * @param httpRequest Lego entity request
	 * @return HTTP 200 if successful
	 */
	@POST
	@Consumes(SnpMediaType.APPLICATION_LEGO_XML)
	public Response postLego(@Context final HttpServletRequest httpRequest) {
		LOGGER.trace("Posted Lego XML");
        Reader reader = null;
        try {
            reader = httpRequest.getReader();
        } catch(Exception e) {
            LOGGER.error("reader error: ", e);
        }
        LOGGER.info("reader: " + reader.toString());
		if (reader == null) {
			LOGGER.error("legoList is null");
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		
//    	for (Lego lego : legoList.getLego()) {
//    		pceClssfrSvcLego.classifyAssertion(lego);
//    	}
		return Response.ok().build();
	}
	
	/**
	 * Handles posted streaming Fhir requests
	 * @param httpRequest Fhir entity requiest
	 * @return HTTP 200 if successful
	 */
	@POST
	@Consumes(SnpMediaType.APPLICATION_FHIR_XML)
	public Response postFhir(@Context final HttpServletRequest httpRequest) {
//		LOGGER.trace("Posted Fhir XML: {}", fhir);
//
//		if (fhir == null) {
//			LOGGER.error("fhir is null");
//			return Response.status(Response.Status.BAD_REQUEST).build();
//		}
//		pceClssfrSvcFhir.classifyAssertion(fhir);
		return Response.ok().build();
	}
	
	/**
	 * Handles posted multipart form requests for file uploads
	 * @param form multipart form request
	 * @return HTTP 200 if successful, HTTP 204 if no content is received
	 */
	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response postFile(final FormDataMultiPart form) {
		LOGGER.trace("Form data multipart: {}", form);

		if (form == null) {
			LOGGER.error("form is null");
			return Response.status(Response.Status.BAD_REQUEST).build();
		}

		// supports multi-file uploads
		List<FormDataBodyPart> fileParts = form.getFields("file");
		for (FormDataBodyPart filePart : fileParts) {
			
			// log body part header info
			if (LOGGER.isDebugEnabled()) {
				for(Entry<String, List<String>> fbHeader: filePart.getHeaders().entrySet()) {
					for(String fbHeaderValue : fbHeader.getValue()) {
						LOGGER.debug("Header: {} --> Value: {}", fbHeader.getKey(), fbHeaderValue);
					}
				}
			}
			
			if (filePart.getContentDisposition() == null 
					|| filePart.getContentDisposition().getSize() <= 0
					|| filePart.getEntity() == null) {
				return Response.status(Response.Status.BAD_REQUEST).build();
			}
			LOGGER.debug("File part media type: {}", filePart.getMediaType());
			@SuppressWarnings("rawtypes")
			Map<MediaType, List<MessageBodyReader>> readers = filePart.messageBodyWorkers
					.getReaders(filePart.getMediaType());
			
			if (LOGGER.isDebugEnabled()) {
				for (@SuppressWarnings("rawtypes") Entry<MediaType, List<MessageBodyReader>> readerMediaType : readers.entrySet()) {
					for (MessageBodyReader<?> reader : readerMediaType.getValue()) {
						LOGGER.debug("MessageBodyReader for Media Type [{}]: {}", readerMediaType.getKey(), reader);
					}
				}
			}
			
			// TODO: Queue processing of data to occur after loop so that all 
			// files can be verified for correctness before we process any
			Class<?> entityClass = SnpMediaTypeMapping.getEntityClassByMediaType(filePart.getMediaType());
			LOGGER.debug("entityClass for media type is: {}", entityClass);

			if (SnpMediaTypeMapping.LEGO.getEntityClass().equals(entityClass)) {
				LOGGER.trace("Starting Lego Binding...");
				//LegoEnvelope legoEnvelope = (LegoEnvelope) filePart.getEntityAs(entityClass);
				//LOGGER.debug("Lego XML: {}", legoEnvelope);
	    		//pceClssfrSvcLego.classifyAssertion(legoEnvelope);
			}
			else if (SnpMediaTypeMapping.FHIR.getEntityClass().equals(entityClass)) {
				LOGGER.trace("Starting Fhir Binding...");
				//FhirEnvelope fhirEnvelope = (FhirEnvelope) filePart.getEntityAs(entityClass);
				//LOGGER.debug("Fhir XML: {}", fhirEnvelope);
				//pceClssfrSvcFhir.classifyAssertion(fhirEnvelope);
			}
		}
		
		return Response.ok().build();
	}
}
