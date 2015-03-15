package com.github.jlgrock.integration.sample;

import com.github.jlgrock.snp.core.sample.PocDemo;
import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.hk2.utilities.ServiceLocatorUtilities;

/**
 *
 */
public class PocDemoCheck {

    public static void main(String[] args) throws Exception {
        ServiceLocator locator = ServiceLocatorUtilities.createAndPopulateServiceLocator();

        PocDemo myService = locator.getService(PocDemo.class);

        myService.query();

    }
}
