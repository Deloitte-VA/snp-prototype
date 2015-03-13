package com.github.jlgrock.snp.core;

import com.github.jlgrock.snp.core.connection.MongoDbFactory;
import com.mongodb.DB;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * The default connection for MongoDB
 */
@Named
public class MyConnection {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyConnection.class);

    private final MongoDbFactory mongo;

    /**
     * 
 	 * @param pmongo is private variable of type MongoDbFactory
 	 */
    @Inject
    public MyConnection(final MongoDbFactory pmongo) {
        this.mongo = pmongo;
    }

    /**
     * Simple output for use in logging.
     */
    public void printAddress() {
        DB db = mongo.getDb();
        LOGGER.info("db address: {}", db.getMongo().getAddress());
    }

}


