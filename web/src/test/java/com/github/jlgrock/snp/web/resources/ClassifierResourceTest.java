package com.github.jlgrock.snp.web.resources;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.hk2.api.Factory;
import org.glassfish.hk2.api.TypeLiteral;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.media.multipart.FormDataBodyPart;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.glassfish.jersey.server.ResourceConfig;
import org.jvnet.testing.hk2testng.HK2;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.jlgrock.snp.core.domain.fhir.Condition;
import com.github.jlgrock.snp.core.domain.lego.Lego;
import com.github.jlgrock.snp.web.controllers.GenericControllerTest;
import com.github.jlgrock.snp.web.services.PceClassifierService;

@HK2(populate = false)
public class ClassifierResourceTest extends GenericControllerTest {

	public static final String RESOURCE_URI = "classifier";
	
	@Mock
	PceClassifierService<Lego> pceClssfrSvcLego;
	
	@Mock
	PceClassifierService<Condition> pceClssfrSvcFhir;
	
	@Override
	protected void registerInjectionPoints(ResourceConfig application) {
		application.registerInstances(new AbstractBinder() {
			@Override
			protected void configure() {
				bindFactory(new Factory<PceClassifierService<Lego>>() {
					@Override
					public PceClassifierService<Lego> provide() {
						return pceClssfrSvcLego;
					}

					@Override
					public void dispose(PceClassifierService<Lego> instance) {
					}
				}).to(new TypeLiteral<PceClassifierService<Lego>>() {}).ranked(DEFAULT_HK2_TEST_BIND_RANK);
			}
		});
		
		application.registerInstances(new AbstractBinder() {
			@Override
			protected void configure() {
				bindFactory(new Factory<PceClassifierService<Condition>>() {
					@Override
					public PceClassifierService<Condition> provide() {
						return pceClssfrSvcFhir;
					}

					@Override
					public void dispose(PceClassifierService<Condition> instance) {
					}
				}).to(new TypeLiteral<PceClassifierService<Condition>>() {}).ranked(DEFAULT_HK2_TEST_BIND_RANK);
			}
		});
	}
	
	@SuppressWarnings("unchecked")
	@BeforeMethod
	public void setup() {
		Mockito.reset(pceClssfrSvcLego);
		Mockito.reset(pceClssfrSvcFhir);
	}
	
	@Test
	public void testStreamingLegoXml() {
		String testXml = readFile("Assertion_Example_01.xml");
		final WebTarget target = target().path(RESOURCE_URI);
		final Response response = target.request(SnpMediaType.APPLICATION_LEGO_XML_TYPE)
				.post(Entity.entity(testXml, SnpMediaType.APPLICATION_LEGO_XML_TYPE));

		// verify return status
		Assert.assertEquals(response.getStatus(), Response.Status.OK.getStatusCode());
		Mockito.verify(pceClssfrSvcLego).classifyAssertion(Mockito.any());
	}
	
	@Test
	public void testStreamingLegoXmlEmpty() {
		final WebTarget target = target().path(RESOURCE_URI);
		final Response response = target.request(SnpMediaType.APPLICATION_LEGO_XML_TYPE)
				.post(Entity.entity(null, SnpMediaType.APPLICATION_LEGO_XML_TYPE));

		// verify return status
		Assert.assertEquals(response.getStatus(), Response.Status.BAD_REQUEST.getStatusCode());
		Mockito.verifyZeroInteractions(pceClssfrSvcLego);
	}
	
	@Test
	public void testLegoXmlFileUpload() {
		final WebTarget target = target().path(RESOURCE_URI);

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
        Mockito.verify(pceClssfrSvcLego).classifyAssertion(Mockito.any());
	}

	@Test
	public void testFhirXmlFileUpload() {
		final WebTarget target = target().path(RESOURCE_URI);

        String testXml = readFile("FHIRCondition-1.xml");
        
        final FormDataMultiPart mp = new FormDataMultiPart();
        final FormDataContentDisposition formDataContentDisposition = FormDataContentDisposition
                .name("file")
                .fileName("fhir.xml")
                .size(testXml.length())
                .build();
        final FormDataBodyPart formDataBodyPart = new FormDataBodyPart(
        		formDataContentDisposition, testXml, 
        		SnpMediaType.APPLICATION_FHIR_XML_TYPE);
        mp.bodyPart(formDataBodyPart);
        
        final Entity<FormDataMultiPart> form = Entity.entity(mp, MediaType.MULTIPART_FORM_DATA_TYPE);
        final Response response = target.request().post(form);
        
        // verify return status
        Assert.assertEquals(response.getStatus(), Response.Status.OK.getStatusCode());
        Mockito.verify(pceClssfrSvcFhir).classifyAssertion(Mockito.any());
	}
	
	@Test
	public void testLegoXmlMultiFileUpload() {
		final WebTarget target = target().path(RESOURCE_URI);

        String testXml = readFile("Assertion_Example_01.xml");
        
        final FormDataMultiPart mp = new FormDataMultiPart();
        
        // file 1
        final FormDataContentDisposition formDataContentDisposition = FormDataContentDisposition
                .name("file")
                .fileName("lego.xml")
                .size(testXml.length())
                .build();
        final FormDataBodyPart formDataBodyPart = new FormDataBodyPart(
        		formDataContentDisposition, testXml, 
        		SnpMediaType.APPLICATION_LEGO_XML_TYPE);
        mp.bodyPart(formDataBodyPart);
        
        // file 2
        final FormDataContentDisposition formDataContentDisposition2 = FormDataContentDisposition
                .name("file")
                .fileName("lego2.xml")
                .size(testXml.length())
                .build();
        final FormDataBodyPart formDataBodyPart2 = new FormDataBodyPart(
        		formDataContentDisposition2, testXml, 
        		SnpMediaType.APPLICATION_LEGO_XML_TYPE);
        mp.bodyPart(formDataBodyPart2);
        
        final Entity<FormDataMultiPart> form = Entity.entity(mp, MediaType.MULTIPART_FORM_DATA_TYPE);
        final Response response = target.request().post(form);
        
        // verify return status
        Assert.assertEquals(response.getStatus(), Response.Status.OK.getStatusCode());
        Mockito.verify(pceClssfrSvcLego, Mockito.times(2)).classifyAssertion(Mockito.any());
	}
	
	@Test
	public void testLegoXmlMultiFileUploadWithAnEmptyFile() {
		final WebTarget target = target().path(RESOURCE_URI);

        String testXml = readFile("Assertion_Example_01.xml");
        
        final FormDataMultiPart mp = new FormDataMultiPart();
        
        // file 1
        final FormDataContentDisposition formDataContentDisposition = FormDataContentDisposition
                .name("file")
                .fileName("lego.xml")
                .size(testXml.length())
                .build();
        final FormDataBodyPart formDataBodyPart = new FormDataBodyPart(
        		formDataContentDisposition, testXml, 
        		SnpMediaType.APPLICATION_LEGO_XML_TYPE);
        mp.bodyPart(formDataBodyPart);
        
        // file 2
        final FormDataContentDisposition formDataContentDisposition2 = FormDataContentDisposition
                .name("file")
                .fileName("lego2.xml")
                .size(0)
                .build();
        final FormDataBodyPart formDataBodyPart2 = new FormDataBodyPart(
        		formDataContentDisposition2, new ByteArrayInputStream(new byte[] {}), 
        		SnpMediaType.APPLICATION_LEGO_XML_TYPE);
        mp.bodyPart(formDataBodyPart2);
        
        final Entity<FormDataMultiPart> form = Entity.entity(mp, MediaType.MULTIPART_FORM_DATA_TYPE);
        final Response response = target.request().post(form);
        
        // verify return status
        Assert.assertEquals(response.getStatus(), Response.Status.BAD_REQUEST.getStatusCode());
        // TODO: should be... Mockito.verifyZeroInteractions(assertClssfrSvc);
        Mockito.verify(pceClssfrSvcLego).classifyAssertion(Mockito.any());
	}
	
	@Test
	public void testStreamingFhirXml() {
		String testXml = readFile("FHIRCondition-1.xml");
		final WebTarget target = target().path(RESOURCE_URI);
		final Response response = target.request(SnpMediaType.APPLICATION_FHIR_XML_TYPE)
				.post(Entity.entity(testXml, SnpMediaType.APPLICATION_FHIR_XML_TYPE));

		// verify return status
		Assert.assertEquals(response.getStatus(), Response.Status.OK.getStatusCode());
		Mockito.verify(pceClssfrSvcFhir).classifyAssertion(Mockito.any());
	}
	
    @Test
    public void testMultiPartWithEmptyFile() {
        final WebTarget target = target().path(RESOURCE_URI);

        final FormDataMultiPart mp = new FormDataMultiPart();
        final FormDataContentDisposition formDataContentDisposition = FormDataContentDisposition
                .name("file")
                .fileName("test.txt")
                .size(0)
                .build();
        final FormDataBodyPart formDataBodyPart = new FormDataBodyPart(
        		formDataContentDisposition, new ByteArrayInputStream(new byte[] {}), 
        		SnpMediaType.APPLICATION_LEGO_XML_TYPE);
        mp.bodyPart(formDataBodyPart);

        final Entity<FormDataMultiPart> form = Entity.entity(mp, MediaType.MULTIPART_FORM_DATA_TYPE);
        final Response response = target.request().post(form);

        // verify return status
        Assert.assertEquals(response.getStatus(), Response.Status.BAD_REQUEST.getStatusCode());
        Mockito.verifyZeroInteractions(pceClssfrSvcLego);
    }
    
    @Test
    public void testMultiPartWithEmptyForm() {
        final WebTarget target = target().path(RESOURCE_URI);

        final Entity<FormDataMultiPart> form = Entity.entity(null, MediaType.MULTIPART_FORM_DATA_TYPE);
        final Response response = target.request().post(form);

        // verify return status
        Assert.assertEquals(response.getStatus(), Response.Status.BAD_REQUEST.getStatusCode());
        Mockito.verifyZeroInteractions(pceClssfrSvcLego);
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
