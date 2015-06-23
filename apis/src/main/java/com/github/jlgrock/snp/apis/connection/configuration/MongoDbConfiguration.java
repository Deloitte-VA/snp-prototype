package com.github.jlgrock.snp.apis.connection.configuration;

import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.jvnet.hk2.annotations.Contract;

import java.util.List;
import java.util.Optional;

/**
 * The individual configuration settings for connecting to the mongodb database.  A separate configuration should be
 * provided for each db connection.
 */
@Contract
public interface MongoDbConfiguration {

    /**
     * @return the user credentials for the user that will log in for all MongoClient connections
     */
    Optional<List<MongoCredential>> getUserCredentials();

    /**
     * The hostname/ip address and port for a single host mode.  If this is set, it is expected
     * that the implementation for {@link MongoDbConfiguration#getHosts} has not been set.
     *
     * @return The hostname/ip address and port for a single host mode.
     */
    Optional<ServerAddress> getHost();

    /**
     * Return the hosts when using replicaSets.  If this is set, it is expected
     * that the implementation for {@link MongoDbConfiguration#getHost} has not been set
     *
     * @return Return the hosts when using replicaSets.
     */
    Optional<List<ServerAddress>> getHosts();


    /**
     * @return the name of the database.
     */
    String getDefaultDatabase();
}

