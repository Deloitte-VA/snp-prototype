package com.github.jlgrock.snp.web.configuration;

import org.glassfish.hk2.api.DynamicConfigurationService;
import org.glassfish.hk2.api.MultiException;
import org.glassfish.hk2.api.Populator;
import org.glassfish.hk2.api.ServiceLocator;

import java.io.IOException;

/**
 *
 */
public class JerseyAutoScan {
    final ServiceLocator serviceLocator;

    public JerseyAutoScan(final ServiceLocator serviceLocatorIn) {
        serviceLocator = serviceLocatorIn;
    }

    public void scan() {
        try {
            DynamicConfigurationService dcs =
                    serviceLocator.getService(DynamicConfigurationService.class);
            Populator populator = dcs.getPopulator();

            populator.populate(new JerseyDescriptorFinder());
        } catch (IOException e) {
            throw new MultiException(e);
        }
    }
}
