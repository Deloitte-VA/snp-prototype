package com.github.jlgrock.snp.web;

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
@ComponentScan({"com.github.jlgrock.snp.web", "com.github.jlgrock.snp.core"})
public class MongoRestApplication {
    private static Logger LOGGER = LoggerFactory.getLogger(MongoRestApplication.class);

    public static void main(String[] args) throws Exception {
        LOGGER.info("Starting Mongo Rest Application.");
        SpringApplication.run(MongoRestApplication.class, args);
    }

}
