package com.github.jlgrock.snp.core.defaultconfig;

import com.github.jlgrock.snp.apis.connection.MongoDBConfiguration;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.jvnet.hk2.annotations.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.UnknownHostException;
import java.util.List;
import java.util.Optional;

/**
 * The configuration object that will parse a properties file on the classpath and use it to connect to the database.
 */
@Service
public class MongoConfig implements MongoDBConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(MongoConfig.class);

    private static final String DEFAULT_HOST = "192.168.59.103";

    private static final String DEFAULT_DATABASE = "test";

    private final ServerAddress host;

    private final List<ServerAddress> hosts;

    private final String defaultDatabase;

    /**
     * Stores the username/password information.
     */
    private final List<MongoCredential> userCredentials;

    /**
     * Constructor that uses all defaults.  This is great for testing a mongo repository
     * that is local and requires no authentication.
     */
    public MongoConfig() {
        userCredentials = null;
            LOGGER.info("Connecting to " + DEFAULT_HOST);
            // TODO until this is pulled from a properties file, this will need to be edited by hand for each user

        ServerAddress hostSet;
        try {
            hostSet = new ServerAddress( DEFAULT_HOST );
        } catch (UnknownHostException e) {
            LOGGER.error("Unable to identify host=" + DEFAULT_HOST, e);
            hostSet = null;
        }
        host = hostSet;
        hosts = null;
        defaultDatabase = DEFAULT_DATABASE;
    }

    /**
     * Connect to a single host.
     *
     * @param userCredentialsIn the user credentials to use for logging in, or null if none are necessary
     * @param hostIn the host to use the credentials on.  If {@literal null}, this will
     *               default to {@link MongoConfig#DEFAULT_DATABASE}
     * @param defaultDatabaseIn the name of the default database
     */
    // TODO this needs to pull from a properties file
    // TODO this needs to check that we aren't using multiple credentials for a single database
    public MongoConfig(final List<MongoCredential> userCredentialsIn,
                       final ServerAddress hostIn,
                       final String defaultDatabaseIn) {
        LOGGER.info("Connecting to " + hostIn.getHost() + ":" + hostIn.getPort());
        userCredentials = userCredentialsIn;
        host = hostIn;
        hosts = null;
        defaultDatabase = defaultDatabaseIn;
    }

    /**
     * Connect to a ReplicaSet.
     *
     * @param userCredentialsIn the user credentials to use for logging in, or null if none are necessary
     * @param hostsIn the host to use the credentials on.  If {@literal null}, this will
     *               default to {@link MongoConfig#DEFAULT_DATABASE}
     * @param defaultDatabaseIn the name of the default database
     */
    public MongoConfig(final List<MongoCredential> userCredentialsIn,
                       final List<ServerAddress> hostsIn,
                       final String defaultDatabaseIn) {
        LOGGER.info("Connecting to ReplicaSet...");
        for (ServerAddress s : hostsIn) {
            LOGGER.info("Host=" + s.getHost() + ":" + s.getPort());
        }
        userCredentials = userCredentialsIn;
        host = null;
        hosts = hostsIn;
        defaultDatabase = defaultDatabaseIn;
    }

    @Override
    public Optional<List<MongoCredential>> getUserCredentials() {
        return Optional.ofNullable(userCredentials);
    }

    @Override
    public Optional<ServerAddress> getHost() {
        return Optional.ofNullable(host);
    }

    @Override
    public Optional<List<ServerAddress>> getHosts() {
        return Optional.ofNullable(hosts);
    }

    @Override
    public String getDefaultDatabase() {
        return defaultDatabase;
    }
}
