package com.github.jlgrock.snp.web.controllers;

import com.github.jlgrock.snp.core.converters.PatientWriteConverter;
import com.github.jlgrock.snp.core.domain.Gender;
import com.github.jlgrock.snp.core.domain.Patient;
import com.github.jlgrock.snp.core.domain.Race;
import com.github.jlgrock.snp.web.ApplicationConfig;
import com.github.jlgrock.snp.web.ApplicationObjectMapper;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.test.JerseyTestNg;
import org.glassfish.jersey.test.TestProperties;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.ws.rs.core.Application;

import static org.testng.Assert.assertEquals;

/**
 *
 */
public class PatientControllerTest extends JerseyTestNg.ContainerPerClassTest {

    @BeforeMethod
    public void setUp() throws Exception {
        // Required to make this work on TestNG
        MockitoAnnotations.initMocks(this);
    }


    @Override
    protected void configureClient(ClientConfig config) {
        config.register(new JacksonFeature()).register(ApplicationObjectMapper.class);
    }

    @Override
    protected Application configure() {
        enable(TestProperties.LOG_TRAFFIC);
        enable(TestProperties.DUMP_ENTITY);

        //return all of the rest endpoints
        return ApplicationConfig.createApp();
    }

    @Test
    public void testFindById() {
        final Long id = 1l;
        final Patient p = new Patient();
        p.setId(id);
        p.setFirstName("abc");
        p.setMiddleName("def");
        p.setLastName("ghi");
        p.setGender(Gender.FEMALE);
        p.setRace(Race.AMERICAN_INDIAN);
        final String response = target("patient/" + id).request().get(String.class);
        final String converted = new PatientWriteConverter().convert(p).toString();
        assertEquals(converted, response);
    }
}
