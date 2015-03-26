package com.github.jlgrock.snp.integration.sample;

import com.github.jlgrock.snp.core.sample.PocDemo;
import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.hk2.utilities.ServiceLocatorUtilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Test the first sample query, including injection, execution, and it prints the results to the console.
 */
public final class PocDemoCheck {

    private static final Logger LOGGER = LoggerFactory.getLogger(PocDemoCheck.class);

    private PocDemoCheck(){}

    /**
     * Run the query test
     * @param args command line arguments - ignored
     * @throws Exception throws an exception if there is anything wrong with the connection or the query (not expected)
     */
    public static void main(final String[] args) throws Exception {
        ServiceLocator locator = ServiceLocatorUtilities.createAndPopulateServiceLocator();

        PocDemo myService = locator.getService(PocDemo.class);

        myService.query();

    }
}
