package com.github.jlgrock.snp.web.controllers;

import com.github.jlgrock.snp.apis.connection.configuration.WebConfiguration;
import com.github.jlgrock.snp.apis.data.MultiPartFileUtils;

import org.glassfish.hk2.api.Factory;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.media.multipart.FormDataBodyPart;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.glassfish.jersey.server.ResourceConfig;
import org.jvnet.testing.hk2testng.HK2;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

@HK2(populate = false)
public class LegoControllerTest extends GenericControllerTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(LegoControllerTest.class);

    WebConfiguration webconfiguration = new WebConfiguration() {
        @Override
        public Path fileLocation() {
            return path;
        }
    };


    private MultiPartFileUtils multiPartFileUtils;


    @Mock
    Path path;

    @Override
    public void registerInjectionPoints(final ResourceConfig application) {
        // register the injection points in HK2
        LOGGER.debug("webconfiguration = " + webconfiguration);

        //TODO figure out how to swap this out for the anonymous methods
        //application.registerInstances(new SimpleBinder<WebConfiguration>(webconfiguration, WebConfiguration.class));
        //application.registerInstances(new SimpleBinder<>(multiPartFileUtils, MultiPartFileUtils.class));
        application.registerInstances(new AbstractBinder() {
            @Override
            protected void configure() {
                bindFactory(new Factory<WebConfiguration>() {
                    @Override
                    public WebConfiguration provide() {
                        return webconfiguration;
                    }

                    @Override
                    public void dispose(WebConfiguration instance) {
                    }
                }).to(WebConfiguration.class);
            }
        });

        application.registerInstances(new AbstractBinder() {
            @Override
            protected void configure() {
                bindFactory(new Factory<MultiPartFileUtils>() {
                    @Override
                    public MultiPartFileUtils provide() {
                        return multiPartFileUtils;
                    }

                    @Override
                    public void dispose(MultiPartFileUtils instance) {
                    }
                }).to(MultiPartFileUtils.class);
            }
        });
    }

    @Test
    public void testPartWithFile() {
        multiPartFileUtils = Mockito.mock(MultiPartFileUtils.class);
        Mockito.when(path.resolve(Mockito.any(String.class))).thenReturn(path);

        final String value = "CONTENT";
        final WebTarget target = target().path("lego/upload");

        final InputStream inputStream = new ByteArrayInputStream("CONTENT_STREAM".getBytes(StandardCharsets.UTF_8));
        final FormDataMultiPart mp = new FormDataMultiPart();
        final FormDataContentDisposition formDataContentDisposition = FormDataContentDisposition
                .name("file")
                .fileName("test.txt")
                .size(value.getBytes().length)
                .build();
        final FormDataBodyPart formDataBodyPart = new FormDataBodyPart(formDataContentDisposition, inputStream, MediaType.APPLICATION_OCTET_STREAM_TYPE);
        mp.bodyPart(formDataBodyPart);

        final Entity<FormDataMultiPart> form = Entity.entity(mp, MediaType.MULTIPART_FORM_DATA_TYPE);
        final Response response = target.request().post(form);

        // Verify that this writes to disk
        Mockito.verify(multiPartFileUtils).writeToFile(Mockito.any(), Mockito.any());

        //Verify the "OK" return type
        Assert.assertEquals(response.getStatus(), 200);
    }


    @Test
    public void testMultiPartFileEmpty() {
        multiPartFileUtils = Mockito.mock(MultiPartFileUtils.class);
        Mockito.when(path.resolve(Mockito.any(String.class))).thenReturn(path);
        final WebTarget target = target().path("lego/upload");

        final FormDataMultiPart mp = new FormDataMultiPart();
        final FormDataContentDisposition formDataContentDisposition = FormDataContentDisposition
                .name("file")
                .fileName("test.txt")
                .size(0)
                .build();
        final FormDataBodyPart formDataBodyPart = new FormDataBodyPart(formDataContentDisposition, new ByteArrayInputStream(new byte[] {}), MediaType.APPLICATION_OCTET_STREAM_TYPE);
        mp.bodyPart(formDataBodyPart);

        final Entity<FormDataMultiPart> form = Entity.entity(mp, MediaType.MULTIPART_FORM_DATA_TYPE);
        final Response response = target.request().post(form);

        Assert.assertEquals(response.getStatus(), 200);
    }
    
    
    @Test
    public void testStreamingXml() {
//    	final String testXml = "<xml>test</xml>";
    	String testXml = readFile("Assertion_Example_01.xml");
    	final WebTarget target = target().path("lego");
    	final Response response = target.request(MediaType.APPLICATION_XML_TYPE)
    			.post(Entity.xml(testXml));
    	final String body = response.readEntity(String.class);
    	
    	Assert.assertEquals(response.getStatus(), 200);
    	Assert.assertEquals(body, testXml);
    }

	/**
	 * Prints the string content read from input stream
	 * @return content in file
	 */
	private String readFile(String xmlFile) {
		BufferedReader br = null;
		StringBuilder out = new StringBuilder();
		try {
			InputStream in = getClass().getClassLoader().getResourceAsStream(xmlFile);
	        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
	        String line;
	        while ((line = reader.readLine()) != null) {
	        	if(!"<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>".equals(line.trim())) {
	        		out.append(line.trim());
	        	}
	        }
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		 return out.toString();
	}
}
