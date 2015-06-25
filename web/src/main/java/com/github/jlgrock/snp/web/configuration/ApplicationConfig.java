package com.github.jlgrock.snp.web.configuration;

import com.github.jlgrock.snp.apis.classifier.LogicClassifierStore;
import io.dropwizard.jersey.jackson.JacksonMessageBodyProvider;
import io.dropwizard.jersey.jackson.JsonProcessingExceptionMapper;
import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.validation.Validation;
import javax.ws.rs.ApplicationPath;

/**
 * The entry point for Jersey to start a web application in a Servlet 3.0 container.
 * This is a simple Jersey + HK2 application that can be bound to Spring IOC, Spring MVC,
 * Guice, as well as a number of others.
 */
@ApplicationPath("/services/")
public class ApplicationConfig extends ResourceConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationConfig.class);

    private final LogicClassifierStore logicClassifierStore;

    /**
     * Sets up all of the standard features.
     *
     * @param serviceLocator the service locator that Jersey uses
     * @param context the servlet context that allows for getting resources from the servlet container
     */
    @Inject
    public ApplicationConfig(final ServiceLocator serviceLocator, final ServletContext context) {
        this(serviceLocator, context, false);
    }

    /**
     * Sets up all of the standard features.
     *
     * @param serviceLocator the service locator that Jersey uses
     * @param context the servlet context that allows for getting resources from the servlet container
     * @param isForTesting if true, skips loading hk2 resources automatically and allows you to do this
     *                     via your own test framework
     */
    protected ApplicationConfig(final ServiceLocator serviceLocator,
                                final ServletContext context,
                                final boolean isForTesting) {
        String s = isForTesting ? "in Testing mode" : "";
        LOGGER.info("Starting MongoRestApplication {}...", s);

        setApplicationName(ApplicationConfig.class.getSimpleName());

        if (!isForTesting) {
            new JerseyAutoScan(serviceLocator, context).scan();
            // preload the LogicGraphClassifier to bootstrap the database
            logicClassifierStore = serviceLocator.getService(LogicClassifierStore.class);
        } else {
            logicClassifierStore = null;
        }

        // Register Feature allowing for Multipart file uploads
        register(MultiPartFeature.class);

        // Register Feature allowing Jackson to serialize objects
        register(JacksonFeature.class);

        // Register Feature that allows for detailed exception messages for jackson mapping issues
        register(new JsonProcessingExceptionMapper());

        // Register Feature allowing jackson to use additional annotations and validations
        register(new JacksonMessageBodyProvider(JacksonConfig.newObjectMapper(), Validation.buildDefaultValidatorFactory().getValidator()));

        // Enable Tracing support.
        property(ServerProperties.TRACING, "ALL");

        // Scans packages for rest services
        packages("com.github.jlgrock.snp.web");

        // Place to manually bind objects, in the case that the Jersey Auto-scan isn't working
        // e.g. bind(x.class).to(y.class);
        //
        // note: if the object is generic, use TypeLiteral
        // e.g. bind(x.class).to(new TypeLiteral<InjectionResolver<SessionInject>>(){});
        //
        register(new AbstractBinder() {
            @Override
            protected void configure() {


            }
        });
    }

    /**
     * Method to cleanup before shutting down.  Currently will just stop the expression
     * service background thread.
     */
    @PreDestroy
    public void destroy() {
        if ( logicClassifierStore != null ) {
            logicClassifierStore.stopExpressionService();
        }
    }
}

