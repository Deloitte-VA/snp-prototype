package com.github.jlgrock.snp.web.controllers;

import com.github.jlgrock.snp.web.configuration.ApplicationConfig;
import com.github.jlgrock.snp.web.configuration.ApplicationObjectMapper;
import com.github.jlgrock.snp.web.configuration.JacksonConfig;
import io.dropwizard.jersey.jackson.JacksonMessageBodyProvider;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTestNg;
import org.glassfish.jersey.test.TestProperties;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;

import javax.validation.Validation;
import javax.ws.rs.core.Application;

//@HK2(populate = false)
public abstract class GenericControllerTest extends JerseyTestNg.ContainerPerClassTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(GenericControllerTest.class);

    @BeforeClass
    public void setUpTests() throws Exception {
        // Required to make this work on TestNG
        MockitoAnnotations.initMocks(this);
    }

    @Override
    public void configureClient(final ClientConfig config) {
        LOGGER.debug("Registering client configurations...");
        config.register(MultiPartFeature.class);
        config.register(
                new JacksonMessageBodyProvider(JacksonConfig.newObjectMapper(),
                        Validation.buildDefaultValidatorFactory().getValidator()));
        config.register(ApplicationObjectMapper.class);
    }

    @Override
    protected Application configure() {
        LOGGER.debug("Registering web application configurations...");
        enable(TestProperties.LOG_TRAFFIC);
        enable(TestProperties.DUMP_ENTITY);

        ResourceConfig application = ApplicationConfig.createApp();
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

}
