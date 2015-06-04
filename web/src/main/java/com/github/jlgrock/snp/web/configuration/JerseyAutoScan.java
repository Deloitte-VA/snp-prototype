package com.github.jlgrock.snp.web.configuration;

import org.glassfish.hk2.api.DynamicConfigurationService;
import org.glassfish.hk2.api.MultiException;
import org.glassfish.hk2.api.Populator;
import org.glassfish.hk2.api.ServiceLocator;

import javax.servlet.ServletContext;
import java.io.IOException;

/**
 *
 */
public class JerseyAutoScan {
    final ServiceLocator serviceLocator;
    final ServletContext servletContext;

    public JerseyAutoScan(final ServiceLocator serviceLocatorIn, final ServletContext servletContextIn) {
        serviceLocator = serviceLocatorIn;
        servletContext = servletContextIn;
    }

    public void scan() {
        try {
            DynamicConfigurationService dcs =
                    serviceLocator.getService(DynamicConfigurationService.class);
            Populator populator = dcs.getPopulator();

            populator.populate(new JerseyDescriptorFinder(servletContext));
        } catch (IOException e) {
            throw new MultiException(e);
        }
    }
}
