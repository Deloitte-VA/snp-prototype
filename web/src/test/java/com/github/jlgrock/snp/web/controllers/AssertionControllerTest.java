//package com.github.jlgrock.snp.web.controllers;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.github.jlgrock.snp.core.data.ClassifiedAssertionRepository;
//import com.github.jlgrock.snp.core.domain.Assertion;
//import com.github.jlgrock.snp.core.domain.ClassifiedAssertion;
//import com.github.jlgrock.snp.web.configuration.JacksonConfig;
//import org.glassfish.hk2.api.Factory;
//import org.glassfish.hk2.utilities.binding.AbstractBinder;
//import org.glassfish.jersey.server.ResourceConfig;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import javax.ws.rs.client.WebTarget;
//
//import static org.testng.Assert.assertEquals;
//
///**
// *
// */
//public class AssertionControllerTest extends GenericControllerTest {
//	
//	@Mock
//	private ClassifiedAssertion assertion;
//	
//	@Mock
//	private ClassifiedAssertionRepository classifiedAssertionRepository;
//	
//	private AssertionController assertionController;
//
//    @Override
//    public void registerInjectionPoints(final ResourceConfig application) {
//        //TODO swap this out for the anonymous class
//        //application.register(new SimpleBinder<>(pceRepository, PceRepository.class));
//        application.register(new AbstractBinder() {
//            @Override
//            protected void configure() {
//                bindFactory(new Factory<ClassifiedAssertionRepository>() {
//                    @Override
//                    public ClassifiedAssertionRepository provide() {
//                        return classifiedAssertionRepository;
//                    }
//
//                    @Override
//                    public void dispose(ClassifiedAssertionRepository instance) {
//                    }
//                }).to(ClassifiedAssertionRepository.class);
//            }
//        });
//    }
//
//    @Test
//    public void testGetPce() {
//    	Mockito.when(classifiedAssertionRepository.findOne(assertion.getId())).thenReturn(assertion);
//        assertionController = new AssertionController(classifiedAssertionRepository);
//    	Assertion actual = assertionController.getAssertion(assertion.getId());
//
//    	assertEquals(actual, assertion);
//    }
//
//    @Test
//    public void testGetPatientRestCall() throws JsonProcessingException {
//        ClassifiedAssertion assertionTemp = new ClassifiedAssertion();
//        assertionTemp.setId(1l);
//        Mockito.when(classifiedAssertionRepository.findOne(Mockito.any())).thenReturn(assertionTemp);
//        final WebTarget target = target("pce/1");
//        String response = target.request().get(String.class);
//        String serialized = JacksonConfig.newObjectMapper().writeValueAsString(assertionTemp);
//        Assert.assertEquals(response, serialized);
//    }
//}
