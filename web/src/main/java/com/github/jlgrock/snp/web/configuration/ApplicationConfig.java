package com.github.jlgrock.snp.web.configuration;

import io.dropwizard.jersey.jackson.JacksonMessageBodyProvider;
import io.dropwizard.jersey.jackson.JsonProcessingExceptionMapper;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Validation;
import javax.ws.rs.ApplicationPath;

/**
 * The entry point for Spring to start a web application in a Servlet 3.0 container.  This is a simple Jersey + HK2
 * application that can be bound to Spring IOC, Spring MVC, Guice, as well as a number of others.
 */
@ApplicationPath("/")
public class ApplicationConfig extends ResourceConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationConfig.class);

    public ApplicationConfig() {
        LOGGER.info("Starting MongoRestApplication...");

        // Register Features

        // Feature allowing for Multipart file uploads
        register(MultiPartFeature.class);

        // Feature allowing Jackson to serialize objects
        register(JacksonFeature.class);

        // Feature that allows for detailed exception messages for jackson mapping issues
        register(new JsonProcessingExceptionMapper());

        // Feature allowing jackson to use additional annotations and validations
        register(new JacksonMessageBodyProvider(JacksonConfig.newObjectMapper(), Validation.buildDefaultValidatorFactory().getValidator()));

        // instruct jackson to know where the resources/controllers are
    	packages("com.github.jlgrock.snp.web");

        // Enable Tracing support.
        property(ServerProperties.TRACING, "ALL");
    }

    public static ResourceConfig createApp() {
        return new ApplicationConfig();
    }
}

