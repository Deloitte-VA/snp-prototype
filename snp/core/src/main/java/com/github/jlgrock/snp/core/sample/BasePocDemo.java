package com.github.jlgrock.snp.core.sample;

import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.DB;
import com.mongodb.MongoClient;

/**
 * Simple example of how to implement Query 1 using Java for semantic normalization prototype using MongoDB Java driver library and aggregation framework. 
 */
public class BasePocDemo {

    private static final Logger LOGGER = LoggerFactory.getLogger(BasePocDemo.class);
 
    public MongoClient mongoClient = null;   
    public DB db = null;
    
    public BasePocDemo() {}
    
    public void setUp( ) {
    	
        try {
            //mongoClient = new MongoClient( "192.168.59.103", 27017 ); //boot2docker ip address
            mongoClient = new MongoClient();  //Works, with local MongoDB instance
        } catch (UnknownHostException e) {
            LOGGER.error("Unable to connect to MongoDB", e);
            return;
        }
        LOGGER.info("Obtained connection to MongoDB");

        // get handle to database
        //db = mongoClient.getDB("test");  //instance name under docker VM
        db = mongoClient.getDB("pocdb"); //local instance db name
        
    }
    
    
    public void tearDown( ) {
    	// release resources
    	if (mongoClient != null) {
    		mongoClient.close();
    	}
    }
    
}
