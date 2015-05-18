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

import org.glassfish.jersey.media.multipart.FormDataBodyPart;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.jlgrock.snp.core.domain.fhir.Condition;
import com.github.jlgrock.snp.core.domain.lego.Lego;
import com.github.jlgrock.snp.core.domain.lego.LegoList;
import com.github.jlgrock.snp.web.SnpMediaType;
import com.github.jlgrock.snp.web.SnpMediaTypeMapping;
import com.github.jlgrock.snp.web.services.PceClassifierService;

/**
 * The controller for handling all classifier requests
 */
@Path("/classifier")
public class ClassifierResource {

	private static final Logger LOGGER = LoggerFactory.getLogger(ClassifierResource.class);
	
	private PceClassifierService<Lego> pceClssfrSvcLego;
	private PceClassifierService<Condition> pceClssfrSvcFhir;
	
	/**
	 * Constructor
	 * @param pceClssfrSvcLegoIn PCE classifier service for LEGO
	 * @param pceClssfrSvcFhirIn PCE classifier service for FHIR
	 */
	@Inject
	public ClassifierResource(final PceClassifierService<Lego> pceClssfrSvcLegoIn, 
			final PceClassifierService<Condition> pceClssfrSvcFhirIn) {
		pceClssfrSvcLego = pceClssfrSvcLegoIn;
		pceClssfrSvcFhir = pceClssfrSvcFhirIn;
	}
	
	/**
	 * Handles posted streaming Lego requests
	 * @param legoList Lego entity
	 * @return HTTP 200 if successful
	 */
	@POST
	@Consumes(SnpMediaType.APPLICATION_LEGO_XML)
	public Response postLego(final LegoList legoList) {
		LOGGER.trace("Posted LegoList: {}", legoList);
		
		if (legoList == null) {
			LOGGER.error("legoList is null");
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		
    	for (Lego lego : legoList.getLego()) {
    		pceClssfrSvcLego.classifyAssertion(lego);
    	}
		return Response.ok().build();
	}
	
	/**
	 * Handles posted streaming Fhir requests
	 * @param fhir Fhir entity
	 * @return HTTP 200 if successful
	 */
	@POST
	@Consumes(SnpMediaType.APPLICATION_FHIR_XML)
	public Response postFhir(final Condition fhir) {
		LOGGER.trace("Posted Fhir Condition: {}", fhir);
		
		if (fhir == null) {
			LOGGER.error("fhir is null");
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		pceClssfrSvcFhir.classifyAssertion(fhir);
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
			Class<?> entityClass = SnpMediaTypeMapping.getEntityClass(filePart.getMediaType());
			LOGGER.debug("entityClass for media type is: {}", entityClass);
			if (entityClass.equals(LegoList.class)) {
				LOGGER.trace("inside LegoList");
				LegoList ll = (LegoList) filePart.getEntityAs(entityClass);
				LOGGER.debug("LegoList: {}", ll);
		    	for (Lego lego : ll.getLego()) {
		    		pceClssfrSvcLego.classifyAssertion(lego);
		    	}
			}
			else if (entityClass.equals(Condition.class)) {
				LOGGER.trace("inside Condition");
				Condition condition = (Condition) filePart.getEntityAs(entityClass);
				LOGGER.debug("Condition: {}", condition);
				pceClssfrSvcFhir.classifyAssertion(condition);
			}
		}
		
		return Response.ok().build();
	}
}
