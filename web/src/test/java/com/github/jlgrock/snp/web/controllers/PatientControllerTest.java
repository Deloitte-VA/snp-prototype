package com.github.jlgrock.snp.web.controllers;

import com.github.jlgrock.snp.core.converters.PatientWriteConverter;
import com.github.jlgrock.snp.core.domain.Gender;
import com.github.jlgrock.snp.core.domain.Patient;
import com.github.jlgrock.snp.core.domain.Race;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.testng.annotations.Test;

import javax.ws.rs.core.Application;

import static org.testng.Assert.assertEquals;

/**
 *
 */
public class PatientControllerTest extends JerseyTest {
    @Override
    protected Application configure() {
        return new ResourceConfig(PatientController.class);
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
