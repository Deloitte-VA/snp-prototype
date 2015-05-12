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

import com.github.jlgrock.snp.core.domain.lego.Lego;
import com.github.jlgrock.snp.core.domain.lego.LegoList;
import com.github.jlgrock.snp.core.model.xml.fhir.Bundle;
import com.github.jlgrock.snp.web.SnpMediaTypeMapping;
import com.github.jlgrock.snp.web.services.PceClassifierService;

/**
 * The controller for handling all classifier requests
 * 
 * @author shalewis
 */
@Path("/classifier")
public class ClassifierResource {

	private static final Logger LOGGER = LoggerFactory.getLogger(ClassifierResource.class);
	
	private PceClassifierService<Lego> pceClssfrSvc;
	
	/**
	 * Constructor
	 * @param pceClssfrSvcIn PCE Classifier Service
	 */
	@Inject
	public ClassifierResource(final PceClassifierService<Lego> pceClssfrSvcIn) {
		pceClssfrSvc = pceClssfrSvcIn;
	}
	
	/**
	 * Handles posted streaming Lego requests
	 * @param legoList Lego entity
	 * @return HTTP 200 if successful
	 */
	@POST
	public Response postLego(final LegoList legoList) {
		LOGGER.debug("Posted LegoList: {}", legoList);
		
		if (legoList == null) {
			LOGGER.error("legoList is null");
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		
		pceClssfrSvc.classifyAssertion(legoList.getLego());
		return Response.ok().build();
	}
	
	/**
	 * Handles posted streaming Fhir requests
	 * @param fhir Fhir entity
	 * @return HTTP 200 if successful
	 */
	@POST
	public Response postFhir(final Bundle fhir) {
		LOGGER.debug("Posted LegoList: {}", fhir);
		
		if (fhir == null) {
			LOGGER.error("fhir is null");
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		
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
		
		if (form == null) {
			LOGGER.error("form is null");
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		LOGGER.debug("Form data multipart: {}", form);
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
			// TODO: Add support for FHIR
			Class<?> entityClass = SnpMediaTypeMapping.getEntityClass(filePart.getMediaType());
			LegoList ll = null;
			ll = (LegoList) filePart.getEntityAs(entityClass);
			
			LOGGER.debug("LegoList: {}", ll);
			pceClssfrSvc.classifyAssertion(ll.getLego());
		}
		
		return Response.ok().build();
	}
}
