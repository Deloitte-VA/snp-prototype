package com.github.jlgrock.integration.connection.security;

import com.github.jlgrock.snp.apis.connection.MongoDBConfiguration;
import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.hk2.utilities.ServiceLocatorUtilities;

/**
 * Bla.
 */
public class ConfigurationCheck {

    //Simple test that can be run via command line to ensure that user credentials are being loaded properly
    public static void main(String[] args) {
        ServiceLocator locator = ServiceLocatorUtilities.createAndPopulateServiceLocator();

        MongoDBConfiguration myService = locator.getService(MongoDBConfiguration.class);

        if (myService == null) {
            System.out.println("Configuration has not been set.");
        } else {
            System.out.println("Configuration has been set...");
            if (!myService.getUserCredentials().isPresent()) {
                System.out.println("Credentials have not been set.");
            } else {
                System.out.println("username: " + myService.getUserCredentials().get().getUsername());
                System.out.println("password: " + myService.getUserCredentials().get().getPassword());
            }
            System.out.println("host: " + myService.getHost());
            System.out.println("port: " + myService.getPort());
            System.out.println("default Database: " + myService.getDefaultDatabase());
        }
    }
}