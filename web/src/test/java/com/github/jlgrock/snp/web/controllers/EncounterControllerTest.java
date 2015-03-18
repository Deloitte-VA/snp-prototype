package com.github.jlgrock.snp.web.controllers;

import com.github.jlgrock.snp.core.converters.EncounterWriteConverter;
import com.github.jlgrock.snp.core.converters.ObservationWriteConverter;
import com.github.jlgrock.snp.core.domain.Encounter;
import com.github.jlgrock.snp.web.ApplicationObjectMapper;
import com.github.jlgrock.snp.web.ApplicationConfig;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.test.JerseyTestNg;
import org.glassfish.jersey.test.TestProperties;
import org.testng.annotations.Test;

import javax.ws.rs.core.Application;
import java.time.LocalDate;

import static org.mockito.Mockito.mock;
import static org.testng.Assert.assertEquals;
/**
 *
 */
public class EncounterControllerTest extends JerseyTestNg.ContainerPerClassTest {
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

