package com.github.jlgrock.snp.web.resources;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.apis.exceptions.ProcessingException;
import com.github.jlgrock.snp.apis.web.ProcessingService;
import com.github.jlgrock.snp.apis.web.ProcessingServiceFactory;
import com.github.jlgrock.snp.web.controllers.GenericControllerTest;

import org.glassfish.hk2.api.Factory;
import org.glassfish.hk2.api.TypeLiteral;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.media.multipart.FormDataBodyPart;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.jvnet.testing.hk2testng.HK2;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@HK2(populate = false)
public class ClassifierResourceTest extends GenericControllerTest {

	public static final String RESOURCE_URI = "classifier";

	@Mock
	ProcessingServiceFactory processingServiceFactory;

	@Mock
	ProcessingService legoProcessingService;

	@Mock
	ProcessingService fhirProcessingService;

	@Mock
	LogicGraphClassifier logicGraphClassifier;

	@Override
	protected Class getClassToTest() {
		return ClassifierResource.class;
	}

	@Override
	protected void registerInjectionPoints(ResourceConfig application) {
		application.registerInstances(new AbstractBinder() {
			@Override
			protected void configure() {
				bindFactory(new Factory<ProcessingServiceFactory>() {
					@Override
					public ProcessingServiceFactory provide() {
						return processingServiceFactory;
					}

					@Override
					public void dispose(ProcessingServiceFactory instance) {
					}
				}).to(new TypeLiteral<ProcessingServiceFactory>() {
				}).ranked(DEFAULT_HK2_TEST_BIND_RANK);
			}
		});

		application.registerInstances(new AbstractBinder() {
			@Override
			protected void configure() {
				bindFactory(new Factory<LogicGraphClassifier>() {
					@Override
					public LogicGraphClassifier provide() {
						return logicGraphClassifier;
					}

					@Override
					public void dispose(LogicGraphClassifier instance) {
					}
				}).to(new TypeLiteral<LogicGraphClassifier>() {
				}).ranked(DEFAULT_HK2_TEST_BIND_RANK);
			}
		});
	}

	@Override
	protected void configureClient(ClientConfig config) {
		config.register(MultiPartFeature.class);
	}

	@BeforeMethod
	public void setup() {
		Mockito.reset(processingServiceFactory);
		Mockito.reset(legoProcessingService);
		Mockito.reset(logicGraphClassifier);

		Mockito.when(
				processingServiceFactory
						.getService(SnpMediaType.APPLICATION_LEGO_XML_TYPE))
				.thenReturn(legoProcessingService);
		Mockito.when(
				processingServiceFactory
						.getService(SnpMediaType.APPLICATION_FHIR_XML_TYPE))
				.thenReturn(fhirProcessingService);
	}

	@Test
	public void testLegoXmlFileUpload() throws ProcessingException {
		final WebTarget target = target().path(RESOURCE_URI);

		String testXml = readFile("Assertion_Example_01.xml");

		final FormDataMultiPart mp = new FormDataMultiPart();
		final FormDataContentDisposition formDataContentDisposition = FormDataContentDisposition
				.name("file").fileName("lego.xml").size(testXml.length())
				.build();
		final FormDataBodyPart formDataBodyPart = new FormDataBodyPart(
				formDataContentDisposition, testXml,
				SnpMediaType.APPLICATION_LEGO_XML_TYPE);
		mp.bodyPart(formDataBodyPart);

		final Entity<FormDataMultiPart> form = Entity.entity(mp,
				MediaType.MULTIPART_FORM_DATA_TYPE);
		final Response response = target.request().post(form);

		// verify return status
		Assert.assertEquals(response.getStatus(),
				Response.Status.OK.getStatusCode());
		Mockito.verify(legoProcessingService).processInput(Mockito.anyString(),
				Mockito.anyString());
	}

	@Test
	public void testFhirXmlFileUpload() throws ProcessingException {
		final WebTarget target = target().path(RESOURCE_URI);

		String testXml = readFile("FHIRCondition-1.xml");

		final FormDataMultiPart mp = new FormDataMultiPart();
		final FormDataContentDisposition formDataContentDisposition = FormDataContentDisposition
				.name("file").fileName("fhir.xml").size(testXml.length())
				.build();
		final FormDataBodyPart formDataBodyPart = new FormDataBodyPart(
				formDataContentDisposition, testXml,
				SnpMediaType.APPLICATION_FHIR_XML_TYPE);
		mp.bodyPart(formDataBodyPart);

		final Entity<FormDataMultiPart> form = Entity.entity(mp,
				MediaType.MULTIPART_FORM_DATA_TYPE);
		final Response response = target.request().post(form);

		// verify return status
		Assert.assertEquals(response.getStatus(),
				Response.Status.OK.getStatusCode());
		Mockito.verify(fhirProcessingService).processInput(Mockito.anyString(),
				Mockito.anyString());
	}

	@Test
	public void testLegoXmlMultiFileUpload() throws ProcessingException {
		final WebTarget target = target().path(RESOURCE_URI);

		String testXml = readFile("Assertion_Example_01.xml");

		final FormDataMultiPart mp = new FormDataMultiPart();

		// file 1
		final FormDataContentDisposition formDataContentDisposition = FormDataContentDisposition
				.name("file").fileName("lego.xml").size(testXml.length())
				.build();
		final FormDataBodyPart formDataBodyPart = new FormDataBodyPart(
				formDataContentDisposition, testXml,
				SnpMediaType.APPLICATION_LEGO_XML_TYPE);
		mp.bodyPart(formDataBodyPart);

		// file 2
		final FormDataContentDisposition formDataContentDisposition2 = FormDataContentDisposition
				.name("file").fileName("lego2.xml").size(testXml.length())
				.build();
		final FormDataBodyPart formDataBodyPart2 = new FormDataBodyPart(
				formDataContentDisposition2, testXml,
				SnpMediaType.APPLICATION_LEGO_XML_TYPE);
		mp.bodyPart(formDataBodyPart2);

		final Entity<FormDataMultiPart> form = Entity.entity(mp,
				MediaType.MULTIPART_FORM_DATA_TYPE);
		final Response response = target.request().post(form);

		// verify return status
		Assert.assertEquals(response.getStatus(),
				Response.Status.OK.getStatusCode());
		Mockito.verify(legoProcessingService, Mockito.times(2)).processInput(
				Mockito.anyString(), Mockito.anyString());
	}

	 @Test
	 public void testLegoXmlMultiFileUploadWithAnEmptyFile() throws ProcessingException {
	 final WebTarget target = target().path(RESOURCE_URI);
	
	 String testXml = readFile("Assertion_Example_01.xml");
	
	 final FormDataMultiPart mp = new FormDataMultiPart();
	
	 // file 1
	 final FormDataContentDisposition formDataContentDisposition =
	 FormDataContentDisposition
	 .name("file")
	 .fileName("lego.xml")
	 .size(testXml.length())
	 .build();
	 final FormDataBodyPart formDataBodyPart = new FormDataBodyPart(
	 formDataContentDisposition, testXml,
	 SnpMediaType.APPLICATION_LEGO_XML_TYPE);
	 mp.bodyPart(formDataBodyPart);
	
	 // file 2
	 final FormDataContentDisposition formDataContentDisposition2 =
	 FormDataContentDisposition
	 .name("file")
	 .fileName("lego2.xml")
	 .size(0)
	 .build();
	 final FormDataBodyPart formDataBodyPart2 = new FormDataBodyPart(
	 formDataContentDisposition2, new ByteArrayInputStream(new byte[] {}),
	 SnpMediaType.APPLICATION_LEGO_XML_TYPE);
	 mp.bodyPart(formDataBodyPart2);
	
	 final Entity<FormDataMultiPart> form = Entity.entity(mp,
	 MediaType.MULTIPART_FORM_DATA_TYPE);
	 final Response response = target.request().post(form);
	
	 // verify return status
	 Assert.assertEquals(response.getStatus(),
	 Response.Status.BAD_REQUEST.getStatusCode());
	 Mockito.verify(legoProcessingService).processInput(Mockito.anyString(), Mockito.anyString());
	 }

	@Test
	public void testMultiPartWithEmptyFile() {
		final WebTarget target = target().path(RESOURCE_URI);

		final FormDataMultiPart mp = new FormDataMultiPart();
		final FormDataContentDisposition formDataContentDisposition = FormDataContentDisposition
				.name("file").fileName("test.txt").size(0).build();
		final FormDataBodyPart formDataBodyPart = new FormDataBodyPart(
				formDataContentDisposition, new ByteArrayInputStream(
						new byte[] {}), SnpMediaType.APPLICATION_LEGO_XML_TYPE);
		mp.bodyPart(formDataBodyPart);

		final Entity<FormDataMultiPart> form = Entity.entity(mp,
				MediaType.MULTIPART_FORM_DATA_TYPE);
		final Response response = target.request().post(form);

		// verify return status
		Assert.assertEquals(response.getStatus(),
				Response.Status.BAD_REQUEST.getStatusCode());
		Mockito.verifyZeroInteractions(legoProcessingService);
		Mockito.verifyZeroInteractions(fhirProcessingService);
	}

	@Test
	public void testMultiPartWithEmptyForm() {
		final WebTarget target = target().path(RESOURCE_URI);

		final Entity<FormDataMultiPart> form = Entity.entity(null,
				MediaType.MULTIPART_FORM_DATA_TYPE);
		final Response response = target.request().post(form);

		// verify return status
		Assert.assertEquals(response.getStatus(),
				Response.Status.BAD_REQUEST.getStatusCode());
		Mockito.verifyZeroInteractions(legoProcessingService);
		Mockito.verifyZeroInteractions(fhirProcessingService);
	}
	
	@Test
	public void testPceLookup() throws IOException {
		final WebTarget target = target().path(RESOURCE_URI + "/100348");
		
		final Response response = target.request().get();
		
		Assert.assertEquals(response.getStatus(), Response.Status.OK.getStatusCode());
		Mockito.verify(logicGraphClassifier).getStatedTermLogicGraph(100348);
	}

	/**
	 * Prints the string content read from input stream
	 * 
	 * @return content in file
	 */
	private String readFile(String xmlFile) {
		BufferedReader br = null;
		StringBuilder out = new StringBuilder();
		try {
			InputStream in = getClass().getClassLoader().getResourceAsStream(
					xmlFile);
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(in));
			String line;
			while ((line = reader.readLine()) != null) {
				if (!"<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"
						.equals(line.trim())) {
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

	static class SnpMediaType extends MediaType {

		/**
		 * A {@code String} constant representing "
		 * {@value #APPLICATION_LEGO_JSON}" media type.
		 */
		public final static String APPLICATION_LEGO_JSON = "application/lego+json";
		/**
		 * A {@link MediaType} constant representing "
		 * {@value #APPLICATION_LEGO_JSON}" media type.
		 */
		public final static MediaType APPLICATION_LEGO_JSON_TYPE = new MediaType(
				"application", "lego+json");
		/**
		 * A {@code String} constant representing "
		 * {@value #APPLICATION_LEGO_XML}" media type.
		 */
		public final static String APPLICATION_LEGO_XML = "application/lego+xml";
		/**
		 * A {@link MediaType} constant representing "
		 * {@value #APPLICATION_LEGO_XML}" media type.
		 */
		public final static MediaType APPLICATION_LEGO_XML_TYPE = new MediaType(
				"application", "lego+xml");

		/**
		 * A {@code String} constant representing "
		 * {@value #APPLICATION_FHIR_JSON}" media type.
		 */
		public final static String APPLICATION_FHIR_JSON = "application/fhir+json";
		/**
		 * A {@link MediaType} constant representing "
		 * {@value #APPLICATION_FHIR_JSON}" media type.
		 */
		public final static MediaType APPLICATION_FHIR_JSON_TYPE = new MediaType(
				"application", "fhir+json");
		/**
		 * A {@code String} constant representing "
		 * {@value #APPLICATION_FHIR_XML}" media type.
		 */
		public final static String APPLICATION_FHIR_XML = "application/fhir+xml";
		/**
		 * A {@link MediaType} constant representing "
		 * {@value #APPLICATION_FHIR_XML}" media type.
		 */
		public final static MediaType APPLICATION_FHIR_XML_TYPE = new MediaType(
				"application", "fhir+xml");
	}
}
