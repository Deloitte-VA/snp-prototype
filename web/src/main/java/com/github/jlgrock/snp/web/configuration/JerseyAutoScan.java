package com.github.jlgrock.snp.web.configuration;

import org.glassfish.hk2.api.DynamicConfigurationService;
import org.glassfish.hk2.api.MultiException;
import org.glassfish.hk2.api.Populator;
import org.glassfish.hk2.api.ServiceLocator;

import javax.servlet.ServletContext;
import java.io.IOException;

/**
 * The autoscanner that will populate the current service locator.
 */
public class JerseyAutoScan {
    private final ServiceLocator serviceLocator;
    private final ServletContext servletContext;

    /**
     * @param serviceLocatorIn the current service locator.  If using Jersey, this should be the one
     *                         injected from Jersey
     * @param servletContextIn the servlet context that allows for getting resources from the servlet container
     */
    public JerseyAutoScan(final ServiceLocator serviceLocatorIn, final ServletContext servletContextIn) {
        serviceLocator = serviceLocatorIn;
        servletContext = servletContextIn;
    }

    /**
     * Scan the current classpath for the appropriate context files and populate the
     * service locator.
     */
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
