package com.github.jlgrock.snp.web;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.ApplicationPath;

/**
 * The entry point for Spring to start a web application in a Servlet 3.0 container.
 */
@ApplicationPath("resources")
public class MongoRestApplication extends ResourceConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(MongoRestApplication.class);
    
    private final ResourceConfig config;

    private MongoRestApplication(){
        super(ApplicationObjectMapper.class, JacksonFeature.class);
        LOGGER.info("Starting MongoRestApplication...");
    	config = packages("com.github.jlgrock.snp.web.controllers");
    }

}

