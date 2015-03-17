package com.github.jlgrock.snp.web;

import com.github.jlgrock.snp.web.controllers.PCEController;
import com.sun.net.httpserver.HttpServer;
import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.UriBuilder;
import java.net.URI;

/**
 * The entry point for Spring to start a web application in a Servlet 3.0 container.
 */
public class MongoRestApplication extends ResourceConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(MongoRestApplication.class);

    private MongoRestApplication(){
    	packages("com.github.jlgrock.snp.web.controllers");
    }

    /**
    * 
    * @param args command line arguments
    * @throws Exception "Starting Mongo Application."
    */
    public static void main(final String[] args) throws Exception {
        LOGGER.info("Starting Mongo Application.");
        MongoRestApplication app = new MongoRestApplication();
        
        URI baseUri = UriBuilder.fromUri("http://localhost/").port(9998).build();
        ResourceConfig config = new ResourceConfig(PCEController.class);
        HttpServer server = JdkHttpServerFactory.createHttpServer(baseUri, config);
    }

}

