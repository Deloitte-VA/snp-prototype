package com.github.jlgrock.snp.core.defaultconfig;

import com.github.jlgrock.snp.apis.connection.MongoDBConfiguration;
import com.github.jlgrock.snp.apis.connection.security.UserCredentials;
import com.google.common.base.Preconditions;
import org.jvnet.hk2.annotations.Service;

import java.util.Optional;

/**
 * The configuration object that will parse a properties file on the classpath and use it to connect to the database.
 */
@Service
public class MongoConfig implements MongoDBConfiguration {

    private static final String LOCAL_HOST = "127.0.0.1";
    private static final int MONGO_DEFAULT_PORT = 27017;
    private static final String DEFAULT_DEFAULT_DATABASE = "test";

    /**
     * Stores the username/password information.
     */
    private final UserCredentials userCredentials;

    /**
     * The hostname or ip address to use for connecting with the MongoClient.
     */
    private final String host;

    /**
     * The port to use for connecting with the MongoClient.
     */
    private final int port;

    /**
     * The default database to use for queries.
     */
    private final String defaultDatabase;

    /**
     * Constructor that uses all defaults.  This is great for testing a mongo repository
     * that is local and requires no authentication.
     */
    public MongoConfig() {
        this(null, null, null, null);
    }

    /**
     * Default Constructor that needs user credentials.  If anything else is not provided, it will use the preset
     * reasonable defaults.
     *
     * @param userCredentialsIn the user credentials to use for logging in, or null if none are necessary
     * @param hostIn the hostname or ip address to connect to mongoDB.  If {@literal null}, this will
     *               default to {@link MongoConfig#LOCAL_HOST}
     * @param portIn the port to connect to.  If {@literal null}, this will default to
     *               {@link MongoConfig#MONGO_DEFAULT_PORT}
     * @param defaultDatabaseIn the default database to use when connecting to mongoDB.  If {@literal null}, this will
     *               default to {@link MongoConfig#DEFAULT_DEFAULT_DATABASE}
     */
    // TODO this needs to pull from a properties file
    public MongoConfig(final UserCredentials userCredentialsIn,
                       final String hostIn, final Integer portIn,
                       final String defaultDatabaseIn) {
        userCredentials = userCredentialsIn;
        host = (hostIn == null) ? LOCAL_HOST : hostIn ;
        port = (portIn == null) ? MONGO_DEFAULT_PORT : portIn;
        if (defaultDatabaseIn != null) {
            Preconditions.checkArgument(defaultDatabaseIn.matches("[\\w-]+"),
                    "Database name must only contain letters, numbers, underscores and dashes!");
            defaultDatabase = defaultDatabaseIn;
        } else {
            defaultDatabase = DEFAULT_DEFAULT_DATABASE;
        }
    }

    @Override
    public Optional<UserCredentials> getUserCredentials() {
        return Optional.ofNullable(userCredentials);
    }

    @Override
    public String getHost() {
        return null;
    }

    @Override
    public int getPort() {
        return port;
    }

    @Override
    public String getDefaultDatabase() {
        return null;
    }
}
