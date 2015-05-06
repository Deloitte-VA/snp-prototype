package com.github.jlgrock.snp.web.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.media.multipart.FormDataBodyPart;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.glassfish.jersey.server.ResourceConfig;
import org.jvnet.testing.hk2testng.HK2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.jlgrock.snp.web.SnpMediaType;

@HK2(populate = false)
public class ClassifierResourceTest extends GenericControllerTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(ClassifierResourceTest.class);
	
	@Override
	protected void registerInjectionPoints(ResourceConfig application) {
		// TODO Auto-generated method stub
		
	}
	
	@Test
	public void testStreamingXml() {
		String testXml = readFile("Assertion_Example_01.xml");
		final WebTarget target = target().path("classifier");
		final Response response = target.request(SnpMediaType.APPLICATION_LEGO_XML_TYPE)
				.post(Entity.entity(testXml, SnpMediaType.APPLICATION_LEGO_XML_TYPE));

		// verify return status
		Assert.assertEquals(response.getStatus(), Response.Status.OK.getStatusCode());
		
		LOGGER.debug("Has Entity: " + response.hasEntity());
		LOGGER.debug("Received response: " + response.readEntity(String.class));
	}
	
	@Test
	public void testLegoXmlFileUpload() {
		final WebTarget target = target().path("classifier");

        String testXml = readFile("Assertion_Example_01.xml");
        
        final FormDataMultiPart mp = new FormDataMultiPart();
        final FormDataContentDisposition formDataContentDisposition = FormDataContentDisposition
                .name("file")
                .fileName("lego.xml")
                .size(testXml.length())
                .build();
        final FormDataBodyPart formDataBodyPart = new FormDataBodyPart(
        		formDataContentDisposition, testXml, 
        		SnpMediaType.APPLICATION_LEGO_XML_TYPE);
        mp.bodyPart(formDataBodyPart);
        
        final Entity<FormDataMultiPart> form = Entity.entity(mp, MediaType.MULTIPART_FORM_DATA_TYPE);
        final Response response = target.request().post(form);
        
        // verify return status
        Assert.assertEquals(response.getStatus(), Response.Status.OK.getStatusCode());
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
