package com.github.jlgrock.snp.web.configuration;

import com.github.jlgrock.snp.apis.connection.MongoDatabaseManager;
import com.github.jlgrock.snp.apis.connection.MongoDbFactory;
import com.github.jlgrock.snp.apis.connection.configuration.MongoDbConfiguration;
import com.github.jlgrock.snp.apis.connection.configuration.WebConfiguration;
import com.github.jlgrock.snp.apis.connection.synchronization.TransactionSynchronizationManager;
import com.github.jlgrock.snp.apis.data.MultiPartFileUtils;
import com.github.jlgrock.snp.apis.web.MediaTypeService;
import com.github.jlgrock.snp.apis.web.ProcessingService;
import com.github.jlgrock.snp.core.defaultconfig.MongoConfig;
import com.github.jlgrock.snp.core.defaultconfig.WebConfig;
import com.github.jlgrock.snp.core.domain.fhir.FhirMediaTypeService;
import com.github.jlgrock.snp.core.domain.fhir.FhirProcessingService;
import com.github.jlgrock.snp.core.domain.fhir.marshallers.FhirMarshallerService;
import com.github.jlgrock.snp.core.domain.fhir.marshallers.FhirMarshallerServiceImpl;
import com.github.jlgrock.snp.core.domain.lego.LegoMediaTypeService;
import com.github.jlgrock.snp.core.domain.lego.LegoProcessingService;
import com.github.jlgrock.snp.core.domain.lego.classifiers.LegoElementClassifierFactory;
import com.github.jlgrock.snp.core.domain.lego.marhsallers.LegoMarshallerService;
import com.github.jlgrock.snp.core.domain.lego.marhsallers.LegoMarshallerServiceImpl;
import com.github.jlgrock.snp.domain.connection.SimpleMongoDbFactory;
import com.github.jlgrock.snp.domain.connection.SynchronizedMongoDatabaseManager;
import com.github.jlgrock.snp.domain.connection.synchronization.CollectionSynchronizationManager;
import com.github.jlgrock.snp.domain.converters.ClassifiedAssertionWriteConverter;
import com.github.jlgrock.snp.domain.converters.ClassifiedPceReadConverter;
import com.github.jlgrock.snp.domain.converters.EncounterReadConverter;
import com.github.jlgrock.snp.domain.converters.EncounterWriteConverter;
import com.github.jlgrock.snp.domain.converters.ObservationReadConverter;
import com.github.jlgrock.snp.domain.converters.ObservationWriteConverter;
import com.github.jlgrock.snp.domain.converters.PatientReadConverter;
import com.github.jlgrock.snp.domain.converters.PatientWriteConverter;
import com.github.jlgrock.snp.domain.data.ClassifiedPceMongoDbStore;
import com.github.jlgrock.snp.domain.data.ClassifiedPceRepository;
import com.github.jlgrock.snp.domain.data.ClassifiedPceRepositoryImpl;
import com.github.jlgrock.snp.domain.data.ClassifiedPceStore;
import com.github.jlgrock.snp.domain.data.EncounterRepository;
import com.github.jlgrock.snp.domain.data.EncounterRepositoryImpl;
import com.github.jlgrock.snp.domain.data.PatientRepository;
import com.github.jlgrock.snp.domain.data.PatientRepositoryImpl;
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
@ApplicationPath("/services/")
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

                // DefaultConfig package implementations
                bind(MongoConfig.class).to(MongoDbConfiguration.class);
                bind(WebConfig.class).to(WebConfiguration.class);

                // Domain package implementations
                bind(SimpleMongoDbFactory.class).to(MongoDbFactory.class);
                bind(SynchronizedMongoDatabaseManager.class).to(MongoDatabaseManager.class);
                bind(CollectionSynchronizationManager.class).to(TransactionSynchronizationManager.class);

                bind(EncounterRepositoryImpl.class).to(EncounterRepository.class);
                bind(PatientRepositoryImpl.class).to(PatientRepository.class);
                bind(ClassifiedPceRepositoryImpl.class).to(ClassifiedPceRepository.class);

                bind(ObservationReadConverter.class).to(ObservationReadConverter.class);
                bind(ObservationWriteConverter.class).to(ObservationWriteConverter.class);

                bind(EncounterReadConverter.class).to(EncounterReadConverter.class);
                bind(EncounterWriteConverter.class).to(EncounterWriteConverter.class);

                bind(PatientReadConverter.class).to(PatientReadConverter.class);
                bind(PatientWriteConverter.class).to(PatientWriteConverter.class);

                bind(ClassifiedPceReadConverter.class).to(ClassifiedPceReadConverter.class);
                bind(ClassifiedAssertionWriteConverter.class).to(ClassifiedAssertionWriteConverter.class);

                bind(ClassifiedPceMongoDbStore.class).to(ClassifiedPceStore.class);

                // Fhir package implementations
                bind(FhirMediaTypeService.class).to(MediaTypeService.class);
                bind(FhirProcessingService.class).to(ProcessingService.class);
                bind(FhirMarshallerServiceImpl.class).to(FhirMarshallerService.class);

                // Lego package implementations
                bind(LegoMediaTypeService.class).to(MediaTypeService.class);
                bind(LegoProcessingService.class).to(ProcessingService.class);
                bind(LegoElementClassifierFactory.class).to(LegoElementClassifierFactory.class);
                bind(LegoMarshallerServiceImpl.class).to(LegoMarshallerService.class);

                // Web package implementations
                bind(MultipartFileUtilsImpl.class).to(MultiPartFileUtils.class);

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

