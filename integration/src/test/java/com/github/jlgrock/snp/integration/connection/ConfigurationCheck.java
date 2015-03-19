package com.github.jlgrock.snp.integration.connection;

import com.github.jlgrock.snp.apis.connection.MongoDbConfiguration;
import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.hk2.utilities.ServiceLocatorUtilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Checks the configuration settings that are injected, based on dependencies
 */
public final class ConfigurationCheck {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConfigurationCheck.class);

    private ConfigurationCheck() {}

    /**
     * Run the configuration test
     * @param args command line arguments - ignored
     */
    //Simple test that can be run via command line to ensure that user credentials are being loaded properly
    public static void main(final String[] args) {
        ServiceLocator locator = ServiceLocatorUtilities.createAndPopulateServiceLocator();

        MongoDbConfiguration myService = locator.getService(MongoDbConfiguration.class);

        if (myService == null) {
            LOGGER.info("Configuration has not been set.");
        } else {
            LOGGER.info("Configuration has been set...");
            if (!myService.getUserCredentials().isPresent()) {
                LOGGER.info("Credentials have not been set.");
            } else {
                LOGGER.info("credentials: " + myService.getUserCredentials().get());
            }
            if (myService.getHost().isPresent()) {
                LOGGER.info("host: " + myService.getHost().get());
            } else {
                LOGGER.info("hosts: " + myService.getHosts().get());
            }
            LOGGER.info("default Database: " + myService.getDefaultDatabase());
        }
    }
}
