package com.github.jlgrock.snp.web.controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.jlgrock.snp.domain.data.EncounterRepository;
import com.github.jlgrock.snp.domain.types.Encounter;
import com.github.jlgrock.snp.web.configuration.JacksonConfig;
import org.glassfish.hk2.api.Factory;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.jvnet.testing.hk2testng.HK2;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

/**
 *
 */
@HK2(populate = false)
public class EncounterControllerTest extends GenericControllerTest {

	@Mock
	private Encounter encounter;
	
	@Mock
	private EncounterRepository encounterRepository;

    private EncounterController encounterController;

    @Override
    protected Class getClassToTest() {
        return EncounterController.class;
    }

    @Override
    public void registerInjectionPoints(final ResourceConfig application) {
        //TODO swap this out for the anonymous class
        //application.register(new SimpleBinder<>(encounterRepository, EncounterRepository.class));
        application.register(new AbstractBinder() {
            @Override
            protected void configure() {
                bindFactory(new Factory<EncounterRepository>() {
                    @Override
                    public EncounterRepository provide() {
                        return encounterRepository;
                    }

                    @Override
                    public void dispose(EncounterRepository instance) {
                    }
                }).to(EncounterRepository.class);
            }
        });
    }

    @Test
    public void testGetEncounterMethod() {
        Mockito.when(encounter.getId()).thenReturn(1l);
    	Mockito.when(encounterRepository.findOneById(encounter.getId())).thenReturn(encounter);
        encounterController = new EncounterController(encounterRepository);
    	Encounter actual = encounterController.getEncounter(encounter.getId());
    	Assert.assertEquals(actual, encounter);
    }

    @Test
    public void testGetEncounterRestCall() throws IOException {
        Encounter encounterTemp = new Encounter();
        encounterTemp.setId(1l);
        encounterTemp.setPatientId(2l);
        encounterTemp.setParticipant("abc");
        encounterTemp.setStatus("def");
        encounterTemp.setSubject("ghi");
        encounterTemp.setEncounterClass("jkl");

        Mockito.when(encounterRepository.findOneById(Mockito.any())).thenReturn(encounterTemp);
        final WebTarget target = target("encounter/1");

        String response = target.request().header("Content-Type", MediaType.APPLICATION_JSON).get(String.class);
        JsonNode responseObj = JacksonConfig.newObjectMapper().readTree(response);
        JsonNode marshalled = JacksonConfig.newObjectMapper().valueToTree(encounterTemp);

        Assert.assertEquals(responseObj, marshalled);
    }

}

