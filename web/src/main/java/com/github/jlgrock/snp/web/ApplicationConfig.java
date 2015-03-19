package com.github.jlgrock.snp.web;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.ApplicationPath;

/**
 * The entry point for Spring to start a web application in a Servlet 3.0 container.
 */
@ApplicationPath("/")
public class ApplicationConfig extends ResourceConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationConfig.class);
    
    public ApplicationConfig() {
        // Register Jackson Features
        register( JacksonFeature.class );

        LOGGER.info("Starting MongoRestApplication...");
    	packages("com.github.jlgrock.snp.web");

        // Enable Tracing support.
        property(ServerProperties.TRACING, "ALL");
    }

    public static ResourceConfig createApp() {
        return new ApplicationConfig();
    }
}

