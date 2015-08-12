package com.github.jlgrock.snp.web.controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.jlgrock.snp.domain.data.PatientRepository;
import com.github.jlgrock.snp.domain.types.Gender;
import com.github.jlgrock.snp.domain.types.Patient;
import com.github.jlgrock.snp.web.configuration.JacksonConfig;
import com.github.jlgrock.snp.web.services.ClassifierQueryServiceImpl;
import com.google.common.io.CharStreams;
import org.bson.types.ObjectId;
import org.glassfish.hk2.api.Factory;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.jvnet.testing.hk2testng.HK2;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static org.testng.Assert.assertEquals;

//import com.github.jlgrock.snp.domain.types.Race;

/**
 *
 */
@HK2
public class PatientControllerTest extends GenericControllerTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(PatientControllerTest.class);
	
	public static final String RESOURCE_URI = "patient";
	
	@Mock
	Patient patient;

	@Mock
	PatientRepository patientRepository;
	
	@Mock
	ClassifierQueryServiceImpl classifierQuerySvc;
	
	private PatientController patientController;


    @Override
    public void registerInjectionPoints(final ResourceConfig application) {
        application.register(new AbstractBinder() {
            @Override
            protected void configure() {
                bindFactory(new Factory<PatientRepository>() {
                    @Override
                    public PatientRepository provide() {
                        return patientRepository;
                    }

                    @Override
                    public void dispose(PatientRepository instance) {
                    }
                }).to(PatientRepository.class).ranked(DEFAULT_HK2_TEST_BIND_RANK);
            }
        });
        application.register(new AbstractBinder() {
        	@Override
        	protected void configure() {
        		bindFactory(new Factory<ClassifierQueryServiceImpl>() {
        			@Override
        			public ClassifierQueryServiceImpl provide() {
        				return classifierQuerySvc;
        			}
        			
        			@Override
        			public void dispose(ClassifierQueryServiceImpl instance) {
        				
        			}
				}).to(ClassifierQueryServiceImpl.class).ranked(DEFAULT_HK2_TEST_BIND_RANK);
        	}
        });
    }

    @Override
    protected Class getClassToTest() {
        return PatientController.class;
    }

	@Override
	@BeforeMethod
    public void setUpTests() throws Exception {
        // Required to make this work on TestNG
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetPatient() {
    	Mockito.when(patientRepository.findOneById(patient.getId())).thenReturn(patient);
        patientController = new PatientController(patientRepository, classifierQuerySvc);
    	Patient actual = patientController.getPatient(patient.getId());

    	assertEquals(actual, patient);
    }

    @Test
    public void testGetPatientRestCall() throws IOException {
        Patient patientTemp = new Patient();
        ObjectId objectId = ObjectId.get();
        patientTemp.setId(objectId);
        patientTemp.setFirstName("a");
        patientTemp.setMiddleName("b");
        patientTemp.setLastName("c");
        patientTemp.setGender(Gender.FEMALE);
        Mockito.when(patientRepository.findOneById(Mockito.eq(objectId))).thenReturn(patientTemp);

        final WebTarget target = target("patient/" + objectId.toString());
        String response = target.request().header("Content-Type", MediaType.APPLICATION_JSON).get(String.class);
        JsonNode marshalled = JacksonConfig.newObjectMapper().valueToTree(patientTemp);
        JsonNode responseObj = JacksonConfig.newObjectMapper().readTree(response);

        Assert.assertEquals(responseObj, marshalled);
    }

    @Override
	@BeforeClass
    public void setUp() throws Exception {
        super.setUp();
    }

    @Override
	@AfterClass
    public void tearDown() throws Exception {
        super.tearDown();
    }
    
    @Test
    public void testGetPatientSearch() throws IOException {
    	final WebTarget target = target().path(RESOURCE_URI + "/search")
    			.queryParam("filter", "observation=234,provenance=456,value=789").queryParam("sort", "1:ASC").queryParam("fields", "1,2");
    	final Response response = target.request(MediaType.APPLICATION_JSON_TYPE).get();
    	
    	LOGGER.debug("Patient search response: " + CharStreams.toString(new InputStreamReader((InputStream) response.getEntity())));
    	Assert.assertEquals(response.getStatus(), Response.Status.OK.getStatusCode());
    }

    
//    @Test
//    public void testGetPatientSearchError() throws IOException {
//    	final WebTarget target = target().path(RESOURCE_URI + "/search");
//    	final Response response = target.request(MediaType.APPLICATION_JSON_TYPE).get();
//    	
//    	LOGGER.debug("Patient search response error: " + CharStreams.toString(new InputStreamReader((InputStream) response.getEntity())));
//    	Assert.assertEquals(response.getStatus(), Response.Status.OK.getStatusCode());
//    }
}
