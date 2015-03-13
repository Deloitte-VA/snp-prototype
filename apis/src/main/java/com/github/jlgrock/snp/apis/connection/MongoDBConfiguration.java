package com.github.jlgrock.snp.apis.connection;

import com.github.jlgrock.snp.apis.connection.security.UserCredentials;
import org.jvnet.hk2.annotations.Contract;

/**
 * The individual configuration settings for connecting to the mongodb server.
 */
@Contract
public interface MongoDBConfiguration {

    /**
     * @return the user credentials for the user that will log in for all MongoClient connections
     */
    public UserCredentials getUserCredentials();

    /**
     * @return the hostname or ip address to use for the server.
     */
    public String getHost();

    /**
     * @return the port to use for the server.
     */
    public String getPort();

    /**
     * @return the name of the default database.
     */
    public String getDefaultDatabase();
}
