package com.github.jlgrock.snp.core.connection;

import com.github.jlgrock.snp.core.connection.security.UserCredentials;
import com.github.jlgrock.snp.core.connection.synchronization.TransactionSynchronizationManager;
import com.github.jlgrock.snp.core.exceptions.DataAccessException;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.WriteConcern;
import org.jvnet.hk2.annotations.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

/**
 * Simple wrapper around the mongodb java library to allow for different levels of synchronization.
 */
@Service
public class SimpleMongoDbFactory implements MongoDbFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleMongoDbFactory.class);

    private final MongoClient mongo;
    private final String defaultDatabaseName;
    private String username;
    private String password;
    private WriteConcern writeConcern;

    @Inject
    private MongoDBConfiguration mongoDBConfiguration;

    @Inject
    private MongoDatabaseManager mongoDatabaseManager;

    @Inject
    TransactionSynchronizationManager synchronizationManager;


    public SimpleMongoDbFactory(final MongoClient mongoIn,
                                final String defaultDatabaseNameIn) {
        if (mongoIn == null) {
            LOGGER.error("Mongo must not be null");
        }
        if (defaultDatabaseNameIn == null) {
            LOGGER.error("Database name must not be empty");
        }
        if (defaultDatabaseNameIn.matches("[\\w-]+")) {
            LOGGER.error("Database name must only contain letters, numbers, underscores and dashes!");
        }
        mongo = mongoIn;
        defaultDatabaseName = defaultDatabaseNameIn;
    }

    public SimpleMongoDbFactory(final MongoClient mongo,
                                final String databaseName,
                                final UserCredentials userCredentials) {
        this(mongo, databaseName);
        this.username = userCredentials.getUsername();
        this.password = userCredentials.getPassword();
    }

    @Override
    public void setWriteConcern(WriteConcern writeConcern) {
        this.writeConcern = writeConcern;
    }

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
    public DB getDb(final String databaseName) throws DataAccessException {

        if (mongo == null) {
            throw new DataAccessException("Cannot open data connection, as mongo is null.");
        }

        String dbName = defaultDatabaseName;
        if (databaseName == null) {
            LOGGER.info("Name of collection is null, using default database=[" + defaultDatabaseName + "]");

            //TODO get default collection from map
        }

        LOGGER.trace("Getting Mongo Database name=[" + databaseName + "]");

        DB db = mongo.getDB(databaseName);

        boolean credentialsGiven = username != null && password != null;
        if (credentialsGiven && !db.isAuthenticated()) {
            // Note, can only authenticate once against the same com.mongodb.DB object.
            if (!db.authenticate(username, password.toCharArray())) {
                throw new DataAccessException("Failed to authenticate to database [" + databaseName
                        + "], username = [" + username + "], password = [" + new String(password) + "]");
            }
        }

        //TODO need to work on synchronization code

        if (writeConcern != null) {
            db.setWriteConcern(writeConcern);
        }

        return db;
    }
}
