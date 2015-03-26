package com.github.jlgrock.snp.web.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.jlgrock.snp.core.data.PceRepository;
import com.github.jlgrock.snp.core.domain.Assertion;
import com.github.jlgrock.snp.web.configuration.JacksonConfig;
import org.glassfish.hk2.api.Factory;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.ws.rs.client.WebTarget;

import static org.testng.Assert.assertEquals;

/**
 *
 */
public class AssertionControllerTest extends GenericControllerTest {
	
	@Mock
	private Assertion assertion;
	
	@Mock
	private PceRepository pceRepository;
	
	private AssertionController assertionController;

    @Override
    public void registerInjectionPoints(final ResourceConfig application) {
        //TODO swap this out for the anonymous class
        //application.register(new SimpleBinder<>(pceRepository, PceRepository.class));
        application.register(new AbstractBinder() {
            @Override
            protected void configure() {
                bindFactory(new Factory<PceRepository>() {
                    @Override
                    public PceRepository provide() {
                        return pceRepository;
                    }

                    @Override
                    public void dispose(PceRepository instance) {
                    }
                }).to(PceRepository.class);
            }
        });
    }

    @Test
    public void testGetPce() {
    	Mockito.when(pceRepository.findOne(assertion.getId())).thenReturn(assertion);
        assertionController = new AssertionController(pceRepository);
    	Assertion actual = assertionController.getPce(assertion.getId());

    	assertEquals(actual, assertion);
    }

    @Test
    public void testGetPatientRestCall() throws JsonProcessingException {
        Assertion assertionTemp = new Assertion();
        assertionTemp.setId(1l);
        Mockito.when(pceRepository.findOne(Mockito.any())).thenReturn(assertionTemp);
        final WebTarget target = target("pce/1");
        String response = target.request().get(String.class);
        String serialized = JacksonConfig.newObjectMapper().writeValueAsString(assertionTemp);
        Assert.assertEquals(response, serialized);
    }
}
