package com.github.jlgrock.snp.apis.connection;

import com.github.jlgrock.snp.apis.connection.security.UserCredentials;
import org.jvnet.hk2.annotations.Contract;

import java.util.Optional;

/**
 * The individual configuration settings for connecting to the mongodb server.
 */
@Contract
public interface MongoDBConfiguration {

    /**
     * @return the user credentials for the user that will log in for all MongoClient connections
     */
    Optional<UserCredentials> getUserCredentials();

    /**
     * @return the hostname or ip address to use for the server.
     */
    String getHost();

    /**
     * @return the port to use for the server.
     */
    int getPort();

    /**
     * @return the name of the default database.
     */
    String getDefaultDatabase();
}
