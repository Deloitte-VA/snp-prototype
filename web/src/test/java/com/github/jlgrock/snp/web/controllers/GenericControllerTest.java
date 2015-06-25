package com.github.jlgrock.snp.web.controllers;

import io.dropwizard.jersey.jackson.JsonProcessingExceptionMapper;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTestNg;
import org.glassfish.jersey.test.TestProperties;
import org.jvnet.testing.hk2testng.HK2;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import javax.ws.rs.core.Application;

@HK2
public abstract class GenericControllerTest extends JerseyTestNg.ContainerPerClassTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(GenericControllerTest.class);

//    @Inject
//    EncounterRepository encounterRepository;

    @BeforeClass
    public void setUpTests() throws Exception {
        // Required to make this work on TestNG
        MockitoAnnotations.initMocks(this);
    }

    @Override
    protected Application configure() {
        LOGGER.debug("Registering web application configurations...");
        enable(TestProperties.LOG_TRAFFIC);
        enable(TestProperties.DUMP_ENTITY);

        Class clazz = getClassToTest();
        LOGGER.info("creating application for resource {}", clazz.getName());
        ResourceConfig application = new ResourceConfig(clazz);

        // Register Feature allowing for Multipart file uploads
        application.register(MultiPartFeature.class);

        // Register Feature allowing Jackson to serialize objects
        application.register(JacksonFeature.class);

        // Register Feature that allows for detailed exception messages for jackson mapping issues
        application.register(new JsonProcessingExceptionMapper());

        registerInjectionPoints(application);
        return application;
    }

    /**
     * register the injection points in HK2
     *
     * example:
     * application.registerInstances(new SimpleBinder<>(webconfiguration, WebConfiguration.class));
     *
     * @param application the application to register with
     */
    protected abstract void registerInjectionPoints(final ResourceConfig application);

    protected abstract Class getClassToTest();

    @BeforeClass
    public void setUp() throws Exception {
        super.setUp();
    }

    @AfterClass
    public void tearDown() throws Exception {
        super.tearDown();
    }
}
