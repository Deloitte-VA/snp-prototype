package com.github.jlgrock.snp.web.resources;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.MessageBodyReader;

import org.glassfish.jersey.media.multipart.ContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataBodyPart;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.jlgrock.snp.core.model.xml.fihr.Bundle;
import com.github.jlgrock.snp.core.domain.lego.Lego;
import com.github.jlgrock.snp.core.domain.lego.LegoList;
import com.github.jlgrock.snp.web.SnpMediaType;
import com.github.jlgrock.snp.web.SnpMediaTypeMapping;
import com.github.jlgrock.snp.web.controllers.AssertionClassifierService;

/**
 * The controller for handling all classifier requests
 * 
 * @author shalewis
 */
@Path("/classifier")
public class ClassifierResource {

	private static final Logger LOGGER = LoggerFactory.getLogger(ClassifierResource.class);
	
	private AssertionClassifierService<Lego> assertClssfrSvc;
	
	@Inject
	public ClassifierResource(final AssertionClassifierService<Lego> assertClssfrSvcIn) {
		assertClssfrSvc = assertClssfrSvcIn;
	}
	
	@POST
	public Response postLego(LegoList legoList) {
		LOGGER.debug("Posted LegoList: {}", legoList);
//		assertClssfrSvc.classifyAssertion(legoList.getLego());
		return Response.ok().entity(legoList.toString()).type(MediaType.TEXT_PLAIN).build();
	}
	
	@POST
	public Response postFhir(Bundle fhir) {
		return Response.ok().build();
	}
	
	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response postFile(final FormDataMultiPart form,
			@Context final HttpHeaders hh,
            @FormDataParam("file") final FormDataContentDisposition fileDisposition,
            @FormDataParam("file") final InputStream is) {
		
		LOGGER.debug("Form data multipart: {}", form);
		
//		FormDataBodyPart filePart = form.getField("file");
//		ContentDisposition headerOfFilePart =  filePart.getContentDisposition();
//		InputStream fileInputStream = filePart.getValueAs(InputStream.class);
		
//		LOGGER.debug("filePart.mediaType: {}", filePart.getMediaType());
		
		// supports multi-file uploads
		List<FormDataBodyPart> fileParts = form.getFields("file");
		for (FormDataBodyPart filePart : fileParts) {
//			LOGGER.debug("filePart.mediaType: {}", filePart.getMediaType());
//			LOGGER.debug("filePart.entity as IS: {}: ", filePart.getEntityAs(InputStream.class));
			
			// log body part header info
			if (LOGGER.isDebugEnabled()) {
				for(String fbHeader: filePart.getHeaders().keySet()) {
					for(String fbHeaderValue : filePart.getHeaders().get(fbHeader)) {
						LOGGER.debug("Header: {} --> Value: {}", fbHeader, fbHeaderValue);
					}
				}
			}
			
//			InputStream fbEntity = filePart.getEntityAs(InputStream.class);
//			LegoList ll = assertClssfrSvc.parseStream(fbEntity);
//			LOGGER.debug("File part LegoList: {}", ll.toString());
			
			LOGGER.debug("File part media type: {}", filePart.getMediaType());
			Map<MediaType, List<MessageBodyReader>> readers = filePart.messageBodyWorkers
					.getReaders(filePart.getMediaType());
			
			if (LOGGER.isDebugEnabled()) {
				for (MediaType readerMediaType : readers.keySet()) {
					for (MessageBodyReader<?> reader : readers.get(readerMediaType)) {
						LOGGER.debug("MessageBodyReader for Media Type [{}]: {}", readerMediaType, reader);
					}
				}
			}
			
//			@SuppressWarnings("rawtypes")
//			List<MessageBodyReader> readerList = filePart.messageBodyWorkers.getReaders(filePart.getMediaType())
//					.get(filePart.getMediaType());
//			
//			if (readerList != null) {
//				for (MessageBodyReader<?> mbr : readerList) {
//					LOGGER.debug("Message body reader: {}", mbr);
//				}
//			}
			
			Class<?> entityClass = SnpMediaTypeMapping.getEntityClass(filePart.getMediaType());
			LegoList ll2 = null;
//			entityClass.newInstance();
			ll2 = (LegoList) filePart.getEntityAs(entityClass);
			
			MessageBodyReader<?> mbr =  filePart.messageBodyWorkers.getMessageBodyReader(
					entityClass, null, null, filePart.getMediaType());
			LOGGER.debug("MBR 2: {}", mbr);
			

//			try {
//				ll2 = (LegoList) mbr.readFrom(entityClass, entityClass.getGenericSuperclass(), new Annotation[] {}, filePart.getMediaType(), hh.getRequestHeaders(), is);
//			} catch (WebApplicationException | IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
			LOGGER.debug("LegoList 2: {}", ll2);
//			assertClssfrSvc.classifyAssertion(ll2.getLegos());
		}
		
		return Response.ok().build();
	}
}
