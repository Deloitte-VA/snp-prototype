package com.github.jlgrock.snp.core.connection;

import com.github.jlgrock.snp.core.connection.security.UserCredentials;

import java.util.Optional;

/**
 * The
 */
public class MongoConfig implements MongoDBConfiguration {

    private final UserCredentials userCredentials;
    private final Optional<String> port;
    private final Optional<String> host;
    private final Optional<String> defaultDatabase;

    public MongoConfig() {
        // TODO this needs to pull from a properties file
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
        host = "127.0.0.1";
        port = "27017";
        defaultDatabase = "test";
    }

    @Override
    public UserCredentials getUserCredentials() {
        if (userCredentials == null) {
            LOGGER.error("The user credentials have not been set.  Please make sure that ")
        }
        return userCredentials;
    }

    @Override
    public String getHost() {
        if (host == null) {
            return "127.0.0.1";
        }
        return null;
    }

    @Override
    public String getPort() {
        if( port == null ) {
            return "27017";
        }
        return port;
    }

    @Override
    public String getDefaultDatabase() {
        return null;
    }
}
