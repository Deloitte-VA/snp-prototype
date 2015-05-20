package com.github.jlgrock.snp.web.controllers;

import static org.testng.Assert.assertEquals;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.hk2.api.Factory;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.jlgrock.snp.core.data.PatientRepository;
import com.github.jlgrock.snp.core.domain.Gender;
import com.github.jlgrock.snp.core.domain.Patient;
import com.github.jlgrock.snp.core.domain.Race;

/**
 *
 */
public class PatientControllerTest extends GenericControllerTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PatientControllerTest.class);
	
	public static final String RESOURCE_URI = "patient";
	
	@Mock
	Patient patient;

	@Mock
	PatientRepository patientRepository;
	
	private PatientController patientController;


    @Override
    public void registerInjectionPoints(final ResourceConfig application) {
        //TODO swap this out for the anonymous class
        //application.register(new SimpleBinder<>(patientRepository, PatientRepository.class));
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
                }).to(PatientRepository.class).ranked(DEFAULT_HK2_TEST_BIND_RANK);;
            }
        });
    }

//    @BeforeMethod
//    public void setUpTests() throws Exception {
//        // Required to make this work on TestNG
//        MockitoAnnotations.initMocks(this);
//    }

    @Test
    public void testGetPatient() {
    	Mockito.when(patientRepository.findOneById(patient.getId())).thenReturn(patient);
        patientController = new PatientController(patientRepository);
    	Patient actual = patientController.getPatient(patient.getId());

    	assertEquals(actual, patient);
    }

    @Test
    public void testGetPatientRestCall() throws JsonProcessingException {
        Patient patientTemp = new Patient();
        patientTemp.setId(1l);
        patientTemp.setFirstName("a");
        patientTemp.setMiddleName("b");
        patientTemp.setLastName("c");
        patientTemp.setGender(Gender.FEMALE);
        patientTemp.setRace(Race.AMERICAN_INDIAN);
        Mockito.when(patientRepository.findOneById(Mockito.any())).thenReturn(patientTemp);
        final WebTarget target = target(RESOURCE_URI + "/1");
//        String response = target.request().get(String.class);
//        String serialized = JacksonConfig.newObjectMapper().writeValueAsString(patientTemp);
//        Assert.assertEquals(response, serialized);
    }
    
    public void testGetPatientSearch() {
    	final WebTarget target = target().path(RESOURCE_URI + "/search");
    	final Response response = target.request(MediaType.APPLICATION_JSON_TYPE).get();
    	
    	LOGGER.debug("Patient search response: " + response.getEntity());
    	Assert.assertEquals(response.getStatus(), Response.Status.OK.getStatusCode());
    }
}
