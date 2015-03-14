package com.github.jlgrock.snp.core.connection;

import com.github.jlgrock.snp.apis.connection.MongoDBConfiguration;
import com.github.jlgrock.snp.apis.connection.MongoDatabaseManager;
import com.github.jlgrock.snp.apis.connection.MongoDbFactory;
import com.github.jlgrock.snp.apis.connection.synchronization.TransactionSynchronizationManager;
import com.github.jlgrock.snp.apis.exceptions.DataAccessException;
import com.google.common.base.Preconditions;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.WriteConcern;
import org.jvnet.hk2.annotations.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.net.UnknownHostException;

/**
 * Simple wrapper around the mongodb java library to allow for different levels of synchronization.
 */
@Service
public class SimpleMongoDbFactory implements MongoDbFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleMongoDbFactory.class);

    private final MongoClient mongo;
    private WriteConcern writeConcern;

    @Inject
    private MongoDBConfiguration mongoDBConfiguration;

    @Inject
    private MongoDatabaseManager mongoDatabaseManager;

    @Inject
    private TransactionSynchronizationManager synchronizationManager;

    /**
     * Create a simple MongoDB connection and return the appropriate database
     *
     * @param mongoDBConfigurationIn the configuration to use to set up the connection
     *
     * @throws UnknownHostException if unable to connect to the database
     */
    public SimpleMongoDbFactory(final MongoDBConfiguration mongoDBConfigurationIn) throws UnknownHostException {
        Preconditions.checkNotNull(mongoDBConfiguration, "Mongo configuration must not be null");
        mongoDBConfiguration = mongoDBConfigurationIn;

        //TODO this needs to be set up for sharding, even possibly several servers on different ports, all on the same machine
        //TODO something like the following...
        //        MongoClient mongoClient = new MongoClient(Arrays.asList(
        //                * new ServerAddress("localhost", 27017),
        //                *   new ServerAddress("localhost", 27018),
        //        *   new ServerAddress("localhost", 27019)));
        //TODO set credentials
        mongo = new MongoClient(mongoDBConfiguration.getHost(), mongoDBConfiguration.getPort());
    }


    @Override
    public void setWriteConcern(final WriteConcern writeConcernIn) {
        writeConcern = writeConcernIn;
    }

    @Override
    public WriteConcern getWriteConcern() {
        return writeConcern;
    }

    @Override
    public void destroy() {
        mongo.close();
    }

    @Override
    public DB getDb() throws DataAccessException {
        return getDb(null);
    }

    @Override
    public DB getDb(final String databaseNameIn) throws DataAccessException {
        if (databaseNameIn == null) {
            LOGGER.info("Name of collection is null, using default database=[" + mongoDBConfiguration.getDefaultDatabase() + "]");

            //TODO get default collection from map
        }

        LOGGER.trace("Getting Mongo Database name=[" + databaseNameIn + "]");

        DB db = mongo.getDB(databaseNameIn);

        //TODO need to work on synchronization code

        if (writeConcern != null) {
            db.setWriteConcern(writeConcern);
        }

        return db;
    }
}
