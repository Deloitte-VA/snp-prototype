package com.github.jlgrock.snp.web.resources;

import java.util.List;
import java.util.Map;

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
	
	private PceClassifierService<Lego> assertClssfrSvc;
	
	@Inject
	public ClassifierResource(final PceClassifierService<Lego> assertClssfrSvcIn) {
		assertClssfrSvc = assertClssfrSvcIn;
	}
	
	@POST
	public Response postLego(LegoList legoList) {
		LOGGER.debug("Posted LegoList: {}", legoList);
		assertClssfrSvc.classifyAssertion(legoList.getLego());
		return Response.ok().entity(legoList.toString()).type(MediaType.TEXT_PLAIN).build();
	}
	
	@POST
	public Response postFhir(Bundle fhir) {
		return Response.ok().build();
	}
	
	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response postFile(final FormDataMultiPart form) {
		
		LOGGER.debug("Form data multipart: {}", form);
		
		// supports multi-file uploads
		List<FormDataBodyPart> fileParts = form.getFields("file");
		for (FormDataBodyPart filePart : fileParts) {
			
			// log body part header info
			if (LOGGER.isDebugEnabled()) {
				for(String fbHeader: filePart.getHeaders().keySet()) {
					for(String fbHeaderValue : filePart.getHeaders().get(fbHeader)) {
						LOGGER.debug("Header: {} --> Value: {}", fbHeader, fbHeaderValue);
					}
				}
			}
			
			LOGGER.debug("File part media type: {}", filePart.getMediaType());
			@SuppressWarnings("rawtypes")
			Map<MediaType, List<MessageBodyReader>> readers = filePart.messageBodyWorkers
					.getReaders(filePart.getMediaType());
			
			if (LOGGER.isDebugEnabled()) {
				for (MediaType readerMediaType : readers.keySet()) {
					for (MessageBodyReader<?> reader : readers.get(readerMediaType)) {
						LOGGER.debug("MessageBodyReader for Media Type [{}]: {}", readerMediaType, reader);
					}
				}
			}
			
			// TODO: Add support for FHIR
			Class<?> entityClass = SnpMediaTypeMapping.getEntityClass(filePart.getMediaType());
			LegoList ll = null;
			ll = (LegoList) filePart.getEntityAs(entityClass);
			
			LOGGER.debug("LegoList: {}", ll);
			assertClssfrSvc.classifyAssertion(ll.getLego());
		}
		
		return Response.ok().build();
	}
}
