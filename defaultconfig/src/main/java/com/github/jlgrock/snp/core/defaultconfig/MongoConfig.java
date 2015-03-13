package com.github.jlgrock.snp.core.defaultconfig;

import com.github.jlgrock.snp.apis.connection.MongoDBConfiguration;
import com.github.jlgrock.snp.apis.connection.security.UserCredentials;

import java.util.Optional;

/**
 * The configuration object that will parse a properties file on the classpath and use it to connect to the database.
 */
public class MongoConfig implements MongoDBConfiguration {

    private static final String LOCAL_HOST = "127.0.0.1";
    private static final String MONGO_DEFAULT_PORT = "27017";
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
    private final String port;

    /**
     * The default database to use for queries.
     */
    private final String defaultDatabase;

    /**
     * Constructor that uses all defaults.  This is great for testing a mongo repository
     * that is local and requires no authentication.
     */
    public MongoConfig() {

        userCredentials = new UserCredentials() {
            @Override
            public String getUsername() {
                return "";
            }

            @Override
            public String getPassword() {
                return "";
            }
        };
        host = LOCAL_HOST;
        port = MONGO_DEFAULT_PORT;
        defaultDatabase = DEFAULT_DEFAULT_DATABASE;
    }

    /**
     * Default Constructor that needs user credentials.  If anything else is not provided, it will
     * use defaults.
     */
    // TODO this needs to pull from a properties file
    public MongoConfig(final Optional<UserCredentials> userCredentialsIn, final Optional<String> portIn, final Optional<String> hostIn, final Optional<String> defaultDatabaseIn) {
        userCredentials = userCredentialsIn.orElseThrow(() -> new IllegalArgumentException("The user credentials have not been set."));
        host = hostIn.orElse(LOCAL_HOST);
        port = portIn.orElse(MONGO_DEFAULT_PORT);
        defaultDatabase = defaultDatabaseIn.orElse(DEFAULT_DEFAULT_DATABASE);
    }

    @Override
    public UserCredentials getUserCredentials() {
        return userCredentials;
    }

    @Override
    public String getHost() {
        return null;
    }

    @Override
    public String getPort() {
        return port;
    }

    @Override
    public String getDefaultDatabase() {
        return null;
    }
}
