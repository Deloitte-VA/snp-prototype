package com.github.jlgrock.snp.core;

import com.github.jlgrock.snp.apis.connection.MongoDbFactory;
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
 	 * @param mongoIn is private variable of type MongoDbFactory
 	 */
    @Inject
    public MyConnection(final MongoDbFactory mongoIn) {
        this.mongo = mongoIn;
    }

    /**
     * Simple output for use in logging.
     */
    public void printAddress() {
        DB db = mongo.getDb();
        LOGGER.info("db address: {}", db.getMongo().getAddress());
    }

}


