package com.github.jlgrock.snp.web.controllers;

import com.github.jlgrock.snp.core.converters.EncounterWriteConverter;
import com.github.jlgrock.snp.core.converters.ObservationWriteConverter;
import com.github.jlgrock.snp.core.domain.Encounter;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.testng.annotations.Test;

import javax.ws.rs.core.Application;
import java.time.LocalDate;

import static org.mockito.Mockito.mock;
import static org.testng.Assert.assertEquals;
/**
 *
 */
public class EncounterControllerTest extends JerseyTest {
    @Override
    protected Application configure() {
        return new ResourceConfig(EncounterController.class);
    }

    @Test
    public void testHello() {
        final String response = target("encounter").request().get(String.class);
        assertEquals("Hello", response);
    }
    @Test
    public void testFindById() {
        final Long id = 1l, patientId = 2l;
        final int type = 9;
        final String reason = "stuff";
        final Encounter e = new Encounter();
        e.setId(id);
        e.setDate(LocalDate.now());
        e.setPatientId(patientId);
        e.setReasonForVisit(reason);
        e.setType(type);
        final String response = target("encounter/" + id).request().get(String.class);
        final String converted = new EncounterWriteConverter(mock(ObservationWriteConverter.class)).
                convert(e).toString();
        assertEquals(converted, response);
    }
}

