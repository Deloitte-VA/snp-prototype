package com.github.jlgrock.snp.web.configuration;

import io.dropwizard.jersey.jackson.JacksonMessageBodyProvider;
import io.dropwizard.jersey.jackson.JsonProcessingExceptionMapper;
import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Validation;
import javax.ws.rs.ApplicationPath;

/**
 * The entry point for Jersey to start a web application in a Servlet 3.0 container.
 * This is a simple Jersey + HK2 application that can be bound to Spring IOC, Spring MVC,
 * Guice, as well as a number of others.
 */
@ApplicationPath("/")
public class ApplicationConfig extends ResourceConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationConfig.class);

    // won't be initialized until onStartup()
    ServiceLocator serviceLocator;

    /**
     * Sets up all of the standard features.
     */
    public ApplicationConfig() {
        LOGGER.info("Starting MongoRestApplication...");

        // Register Features

        //register(Binder.class);
        // Feature allowing for Multipart file uploads
        register(MultiPartFeature.class);

        // Feature allowing Jackson to serialize objects
        register(JacksonFeature.class);

        // Feature that allows for detailed exception messages for jackson mapping issues
        register(new JsonProcessingExceptionMapper());

        // Feature allowing jackson to use additional annotations and validations
        register(new JacksonMessageBodyProvider(JacksonConfig.newObjectMapper(), Validation.buildDefaultValidatorFactory().getValidator()));

        // Enable Tracing support.
        property(ServerProperties.TRACING, "ALL");

        packages("com.github.jlgrock.snp.web");
        //doesn't work
        // ServiceLocator locator = ServiceLocatorUtilities.createAndPopulateServiceLocator();

        //doesn't work
        //register(EncounterRepository.class);

        // TODO this is supposed to work with just the packages(String...) function, but it doesn't seem to be working.
        // The scan of packages doesn't seem to be working, so I have to create an abstract binder to bind classes
        register(new AbstractBinder() {
            @Override
            protected void configure() {
                //bind(EncounterRepositoryImpl.class).to(EncounterRepository.class);

            }
        });
    }


    /**
     * Create and return an application configuration, for use in starting a jersey server.
     * @return the configuration object, which can be modified further.
     */
    public static ResourceConfig createApp() {
        return new ApplicationConfig();
    }

}

