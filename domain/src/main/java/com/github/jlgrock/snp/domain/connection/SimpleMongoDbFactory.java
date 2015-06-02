package com.github.jlgrock.snp.domain.connection;

import com.github.jlgrock.snp.apis.connection.MongoDatabaseManager;
import com.github.jlgrock.snp.apis.connection.MongoDbFactory;
import com.github.jlgrock.snp.apis.connection.configuration.MongoDbConfiguration;
import com.github.jlgrock.snp.apis.connection.synchronization.TransactionSynchronizationManager;
import com.github.jlgrock.snp.apis.exceptions.DataAccessException;
import com.google.common.base.Preconditions;
import com.mongodb.MongoClient;
import com.mongodb.WriteConcern;
import com.mongodb.client.MongoDatabase;
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
    private final MongoDbConfiguration mongoDBConfiguration;
    private final MongoDatabaseManager mongoDatabaseManager;
    private final TransactionSynchronizationManager synchronizationManager;
    private WriteConcern writeConcern;
    private MongoClient mongoClient;

    /**
     * Create a simple MongoDB connection and return the appropriate database
     *
     * @param mongoDBConfigurationIn   the configuration to use to set up the connection
     * @param mongoDatabaseManagerIn   the database manager to index database connections
     * @param synchronizationManagerIn the synchronization manager that will weave synchronization through the access
     * @throws UnknownHostException if unable to connect to the database
     */
    @Inject
    public SimpleMongoDbFactory(final MongoDbConfiguration mongoDBConfigurationIn,
                                final MongoDatabaseManager mongoDatabaseManagerIn,
                                final TransactionSynchronizationManager synchronizationManagerIn) throws UnknownHostException {
        Preconditions.checkNotNull(mongoDBConfigurationIn, "Mongo configuration must not be null");
        mongoDBConfiguration = mongoDBConfigurationIn;

        //TODO this needs to be set up for sharding, even possibly several servers on different ports, all on the same machine
        //TODO something like the following...
        //        MongoClient mongoClient = new MongoClient(Arrays.asList(
        //                * new ServerAddress("localhost", 27017),
        //                *   new ServerAddress("localhost", 27018),
        //        *   new ServerAddress("localhost", 27019)));
        //TODO set credentials

        mongoDatabaseManager = mongoDatabaseManagerIn;
        synchronizationManager = synchronizationManagerIn;
    }

    @Override
    public WriteConcern getWriteConcern() {
        return writeConcern;
    }

    @Override
    public void setWriteConcern(final WriteConcern writeConcernIn) {
        writeConcern = writeConcernIn;
    }

    @Override
    public void destroy() {
        mongoClient.close();
    }

    @Override
    public MongoDatabase db() throws DataAccessException {
        return db(null);
    }

    @Override
    public MongoDatabase db(final String databaseNameIn) throws DataAccessException {
        String databaseToUse;
        if (databaseNameIn == null) {
            LOGGER.info("Name of database is null, using default database=[" + mongoDBConfiguration.getDefaultDatabase() + "]");
            databaseToUse = mongoDBConfiguration.getDefaultDatabase();
            //TODO get default collection from map
        } else {
            databaseToUse = databaseNameIn;
        }

        if (mongoClient == null) {
            createConnection();
        }

        if (writeConcern != null) {
            mongoClient.setWriteConcern(WriteConcern.JOURNALED);
        }

        LOGGER.trace("Getting Mongo Database name=[" + databaseToUse + "]");

        MongoDatabase db;
        if (mongoDatabaseManager.containsDatabase(databaseToUse)) {
            db = mongoDatabaseManager.getDatabase(databaseToUse);
        } else {
            db = mongoClient.getDatabase(databaseToUse);
            mongoDatabaseManager.addDatabase(databaseToUse, db);
        }

        //TODO need to work on synchronization code

        return db;
    }

    private void createConnection() {
        Preconditions.checkState(mongoDBConfiguration.getHost().isPresent() || mongoDBConfiguration.getHosts().isPresent());

        if (mongoDBConfiguration.getHost().isPresent()) {
            // the server is using a standalone database
            if (mongoDBConfiguration.getUserCredentials().isPresent()) {
                mongoClient = new MongoClient(mongoDBConfiguration.getHost().get(), mongoDBConfiguration.getUserCredentials().get());
            } else {
                mongoClient = new MongoClient(mongoDBConfiguration.getHost().get());
            }
        } else {
            // The server is using a replica set
            if (mongoDBConfiguration.getUserCredentials().isPresent()) {
                mongoClient = new MongoClient(mongoDBConfiguration.getHosts().get(), mongoDBConfiguration.getUserCredentials().get());
            } else {
                mongoClient = new MongoClient(mongoDBConfiguration.getHosts().get());
            }
        }
        // create single host
    }

}
