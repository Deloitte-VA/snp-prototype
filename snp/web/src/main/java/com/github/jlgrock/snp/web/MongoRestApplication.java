package com.github.jlgrock.snp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoRepositoriesAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by jlgrock on 1/11/15.
 */
@Configuration
@EnableAutoConfiguration(exclude = {MongoRepositoriesAutoConfiguration.class})
@ComponentScan
public class MongoRestApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(MongoRestApplication.class);
    private MongoRestApplication(){};
    /**
    * 
    * @param args command line arguments
    * @throws Exception "Starting Mongo Application."
    */
    public static void main(final String[] args) throws Exception {
        LOGGER.info("Starting Mongo Application.");
        SpringApplication.run(MongoRestApplication.class, args);
    }

}

