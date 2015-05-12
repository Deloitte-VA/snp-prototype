package com.github.jlgrock.snp.web.providers;

//import java.io.IOException;
//import java.io.InputStream;
//import java.lang.annotation.Annotation;
//import java.lang.reflect.Type;
//
//import javax.inject.Inject;
//import javax.ws.rs.Consumes;
//import javax.ws.rs.WebApplicationException;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.MultivaluedMap;
//import javax.ws.rs.ext.MessageBodyReader;
//import javax.ws.rs.ext.Provider;
//
//import org.apache.mahout.math.Arrays;
//import org.slf4j.LoggerFactory;
//import org.slf4j.Logger;
//
//import com.github.jlgrock.snp.core.model.xml.lego.LegoList;
//import com.github.jlgrock.snp.web.SnpMediaType;
//import com.github.jlgrock.snp.web.services.PceClassifierService;

/**
 * A Jersey (JSR-339) provider for reading request Lego entity bodies
 * @author shalewis
 *
 */
//@Provider
//@Consumes(SnpMediaType.APPLICATION_LEGO_XML)
public class LegoMessageBodyReader {//implements MessageBodyReader<LegoList> {
	
//	private static final Logger LOGGER = LoggerFactory.getLogger(LegoMessageBodyReader.class);
//	private AssertionClassifierService assrtnClssfrSvc;
//	
//	@Inject
//	public LegoMessageBodyReader(AssertionClassifierService assrtnClssfrSvcIn) {
//		assrtnClssfrSvc = assrtnClssfrSvcIn;
//	}
//
//	@Override
//	public boolean isReadable(Class<?> type, Type genericType,
//			Annotation[] annotations, MediaType mediaType) {
//		if (type == null) {
//			return false;
//		}
//		return LegoList.class.isAssignableFrom(type);
//	}
//
//	@Override
//	public LegoList readFrom(Class<LegoList> type, Type genericType,
//			Annotation[] annotations, MediaType mediaType,
//			MultivaluedMap<String, String> httpHeaders, InputStream entityStream)
//			throws IOException, WebApplicationException {
//		
//		if (LOGGER.isDebugEnabled()) {
//			StringBuilder sb = new StringBuilder();
//			sb.append("type = ").append(type);
//			sb.append(", genericType = ").append(genericType);
//			sb.append(", annotations = ").append(Arrays.toString(annotations));
//			sb.append(", mediaType = ").append(mediaType);
//			sb.append(", httpHeaders = ").append(httpHeaders);
//			LOGGER.debug(sb.toString());
//		}
//		return assrtnClssfrSvc.parseStream(entityStream);
//	}

}
