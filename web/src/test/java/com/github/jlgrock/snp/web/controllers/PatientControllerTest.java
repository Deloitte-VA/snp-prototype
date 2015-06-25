package com.github.jlgrock.snp.web.controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.jlgrock.snp.domain.data.PatientRepository;
import com.github.jlgrock.snp.domain.types.Gender;
import com.github.jlgrock.snp.domain.types.Patient;
import com.github.jlgrock.snp.web.configuration.JacksonConfig;
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
import java.io.IOException;

import static org.testng.Assert.assertEquals;

/**
 *
 */
@HK2
public class PatientControllerTest extends GenericControllerTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(PatientControllerTest.class);
	
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
                }).to(PatientRepository.class);
            }
        });
    }

    @Override
    protected Class getClassToTest() {
        return PatientController.class;
    }

	@BeforeMethod
    public void setUpTests() throws Exception {
        // Required to make this work on TestNG
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetPatient() {
    	Mockito.when(patientRepository.findOneById(patient.getId())).thenReturn(patient);
        patientController = new PatientController(patientRepository);
    	Patient actual = patientController.getPatient(patient.getId());

    	assertEquals(actual, patient);
    }

    @Test
    public void testGetPatientRestCall() throws IOException {
        Patient patientTemp = new Patient();
        patientTemp.setId(1l);
        patientTemp.setFirstName("a");
        patientTemp.setMiddleName("b");
        patientTemp.setLastName("c");
        patientTemp.setGender(Gender.FEMALE);
        Mockito.when(patientRepository.findOneById(Mockito.eq(1l))).thenReturn(patientTemp);

        final WebTarget target = target("patient/1");
        String response = target.request().header("Content-Type", MediaType.APPLICATION_JSON).get(String.class);
        JsonNode marshalled = JacksonConfig.newObjectMapper().valueToTree(patientTemp);
        JsonNode responseObj = JacksonConfig.newObjectMapper().readTree(response);

        Assert.assertEquals(responseObj, marshalled);
    }

    @BeforeClass
    public void setUp() throws Exception {
        super.setUp();
    }

    @AfterClass
    public void tearDown() throws Exception {
        super.tearDown();
    }
}
