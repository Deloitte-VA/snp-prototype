package com.github.jlgrock.snp.web.configuration;

import com.github.jlgrock.snp.apis.connection.MongoDatabaseManager;
import com.github.jlgrock.snp.apis.connection.MongoDbFactory;
import com.github.jlgrock.snp.apis.connection.configuration.MongoDbConfiguration;
import com.github.jlgrock.snp.apis.connection.configuration.WebConfiguration;
import com.github.jlgrock.snp.apis.connection.synchronization.TransactionSynchronizationManager;
import com.github.jlgrock.snp.apis.data.MultiPartFileUtils;
import com.github.jlgrock.snp.core.classifier.PceClassifier;
import com.github.jlgrock.snp.core.classifier.LegoClassifierImpl;
import com.github.jlgrock.snp.core.connection.SimpleMongoDbFactory;
import com.github.jlgrock.snp.core.connection.SynchronizedMongoDatabaseManager;
import com.github.jlgrock.snp.core.connection.synchronization.CollectionSynchronizationManager;
import com.github.jlgrock.snp.core.converters.ClassifiedPceReadConverter;
import com.github.jlgrock.snp.core.converters.ClassifiedAssertionWriteConverter;
import com.github.jlgrock.snp.core.converters.EncounterReadConverter;
import com.github.jlgrock.snp.core.converters.EncounterWriteConverter;
import com.github.jlgrock.snp.core.converters.ObservationReadConverter;
import com.github.jlgrock.snp.core.converters.ObservationWriteConverter;
import com.github.jlgrock.snp.core.converters.PatientReadConverter;
import com.github.jlgrock.snp.core.converters.PatientWriteConverter;
import com.github.jlgrock.snp.core.data.ClassifiedAssertionMongoDbStore;
import com.github.jlgrock.snp.core.data.ClassifiedAssertionRepository;
import com.github.jlgrock.snp.core.data.ClassifiedAssertionRepositoryImpl;
import com.github.jlgrock.snp.core.data.ClassifiedAssertionStore;
import com.github.jlgrock.snp.core.data.EncounterRepository;
import com.github.jlgrock.snp.core.data.EncounterRepositoryImpl;
import com.github.jlgrock.snp.core.data.PatientRepository;
import com.github.jlgrock.snp.core.data.PatientRepositoryImpl;
import com.github.jlgrock.snp.core.defaultconfig.MongoConfig;
import com.github.jlgrock.snp.core.defaultconfig.WebConfig;
import com.github.jlgrock.snp.web.controllers.PceClassifierService;
import com.github.jlgrock.snp.web.controllers.PceClassifierServiceImpl;
import com.github.jlgrock.snp.web.controllers.MultipartFileUtilsImpl;

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

import javax.validation.Validation;
import javax.ws.rs.ApplicationPath;

/**
 * The entry point for Jersey to start a web application in a Servlet 3.0 container.
 * This is a simple Jersey + HK2 application that can be bound to Spring IOC, Spring MVC,
 * Guice, as well as a number of others.
 */
@ApplicationPath("/")
public class ApplicationConfig extends ResourceConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationConfig.class);

    // won't be initialized until onStartup()
    ServiceLocator serviceLocator;

    /**
     * Sets up all of the standard features.
     */
    public ApplicationConfig() {
        LOGGER.info("Starting MongoRestApplication...");

        // Register Features

        //register(Binder.class);
        // Feature allowing for Multipart file uploads
        register(MultiPartFeature.class);

        // Feature allowing Jackson to serialize objects
        register(JacksonFeature.class);

        // Feature that allows for detailed exception messages for jackson mapping issues
        register(new JsonProcessingExceptionMapper());

        // Feature allowing jackson to use additional annotations and validations
        register(new JacksonMessageBodyProvider(JacksonConfig.newObjectMapper(), Validation.buildDefaultValidatorFactory().getValidator()));

        // Enable Tracing support.
        property(ServerProperties.TRACING, "ALL");

        packages("com.github.jlgrock.snp.web");
        //doesn't work
        // ServiceLocator locator = ServiceLocatorUtilities.createAndPopulateServiceLocator();

        //doesn't work
        //register(EncounterRepository.class);

        // TODO this is supposed to work with just the packages(String...) function, but it doesn't seem to be working.
        // The scan of packages doesn't seem to be working, so I have to create an abstract binder to bind classes
        register(new AbstractBinder() {
            @Override
            protected void configure() {
                bind(EncounterRepositoryImpl.class).to(EncounterRepository.class);
                bind(PatientRepositoryImpl.class).to(PatientRepository.class);
                bind(ClassifiedAssertionRepositoryImpl.class).to(ClassifiedAssertionRepository.class);
                
                bind(PceClassifierServiceImpl.class).to(PceClassifierService.class);
                bind(LegoClassifierImpl.class).to(PceClassifier.class);
                bind(ClassifiedAssertionMongoDbStore.class).to(ClassifiedAssertionStore.class);
                bind(MultipartFileUtilsImpl.class).to(MultiPartFileUtils.class);

                bind(ObservationReadConverter.class).to(ObservationReadConverter.class);
                bind(ObservationWriteConverter.class).to(ObservationWriteConverter.class);

                bind(EncounterReadConverter.class).to(EncounterReadConverter.class);
                bind(EncounterWriteConverter.class).to(EncounterWriteConverter.class);

                bind(PatientReadConverter.class).to(PatientReadConverter.class);
                bind(PatientWriteConverter.class).to(PatientWriteConverter.class);

                bind(ClassifiedPceReadConverter.class).to(ClassifiedPceReadConverter.class);
                bind(ClassifiedAssertionWriteConverter.class).to(ClassifiedAssertionWriteConverter.class);


                bind(SimpleMongoDbFactory.class).to(MongoDbFactory.class);
                bind(MongoConfig.class).to(MongoDbConfiguration.class);
                bind(WebConfig.class).to(WebConfiguration.class);
                bind(SynchronizedMongoDatabaseManager.class).to(MongoDatabaseManager.class);
                bind(CollectionSynchronizationManager.class).to(TransactionSynchronizationManager.class);
            }
        });
    }


    /**
     * Create and return an application configuration, for use in starting a jersey server.
     * @return the configuration object, which can be modified further.
     */
    public static ResourceConfig createApp() {
        return new ApplicationConfig();
    }

}

