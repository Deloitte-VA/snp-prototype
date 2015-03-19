package com.github.jlgrock.snp.web;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * The entry point for Spring to start a web application in a Servlet 3.0 container.
 */
@ApplicationPath("/")
public class ApplicationConfig extends ResourceConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationConfig.class);
    
    /**
     * Default constructor. Scans the <code>com.github.jlgrock.snp.web</code> package 
     * for JAX-RS annotated classes at application startup.
     */
    public ApplicationConfig() {
        // Register Jackson Features
        register( JacksonFeature.class );

        LOGGER.info("Starting MongoRestApplication...");
    	packages("com.github.jlgrock.snp.web");

        // Enable Tracing support.
        property(ServerProperties.TRACING, "ALL");
    }

    /**
     * Returns a new ApplicationConfig instance.
     * @return New instance of ApplicationConfig
     */
    public static Application createApp() {
        return new ApplicationConfig();
    }
}

