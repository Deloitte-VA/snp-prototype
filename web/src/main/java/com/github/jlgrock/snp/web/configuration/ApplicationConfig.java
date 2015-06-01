package com.github.jlgrock.snp.web.configuration;

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

import javax.inject.Inject;
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

    /**
     * Sets up all of the standard features.
     */
    @Inject
    public ApplicationConfig(final ServiceLocator serviceLocator) {
        LOGGER.info("Starting MongoRestApplication...");

        setApplicationName(ApplicationConfig.class.getSimpleName());

        new JerseyAutoScan(serviceLocator).scan();

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

        // Jersey won't use the service locator, so we have to bind individually
        // note: if the object is generic, use TypeLiteral
        // e.g. bind(x.class).to(new TypeLiteral<InjectionResolver<SessionInject>>(){});
        register(new AbstractBinder() {
            @Override
            protected void configure() {
//
//                // DefaultConfig package implementations
//                bind(MongoConfig.class).to(MongoDbConfiguration.class);
//                bind(WebConfig.class).to(WebConfiguration.class);
//
//                // Domain package implementations
//                bind(LogicGraphClassifierImpl.class)
//                        .to(LogicGraphClassifier.class)
//                        .in(Singleton.class).loadedBy();
//
//                bind(SimpleMongoDbFactory.class).to(MongoDbFactory.class);
//                bind(SynchronizedMongoDatabaseManager.class).to(MongoDatabaseManager.class);
//                bind(CollectionSynchronizationManager.class).to(TransactionSynchronizationManager.class);
//
//                bind(EncounterRepositoryImpl.class).to(EncounterRepository.class);
//                bind(PatientRepositoryImpl.class).to(PatientRepository.class);
//                bind(ClassifiedPceRepositoryImpl.class).to(ClassifiedPceRepository.class);
//
//                bind(ObservationReadConverter.class).to(ObservationReadConverter.class);
//                bind(ObservationWriteConverter.class).to(ObservationWriteConverter.class);
//
//                bind(EncounterReadConverter.class).to(EncounterReadConverter.class);
//                bind(EncounterWriteConverter.class).to(EncounterWriteConverter.class);
//
//                bind(PatientReadConverter.class).to(PatientReadConverter.class);
//                bind(PatientWriteConverter.class).to(PatientWriteConverter.class);
//
//                bind(ClassifiedPceReadConverter.class).to(ClassifiedPceReadConverter.class);
//                bind(ClassifiedAssertionWriteConverter.class).to(ClassifiedAssertionWriteConverter.class);
//
//                bind(ClassifiedPceMongoDbStore.class).to(ClassifiedPceStore.class);
//
//                // Fhir package implementations
//                bind(FhirMediaTypeService.class).to(MediaTypeService.class);
//                bind(FhirProcessingService.class).to(ProcessingService.class);
//                bind(FhirMarshallerServiceImpl.class).to(FhirMarshallerService.class);
//
//                // Lego package implementations
//                bind(LegoMediaTypeService.class).to(MediaTypeService.class);
//                bind(LegoProcessingService.class).to(ProcessingService.class);
//                bind(LegoElementProcessorFactory.class).to(LegoElementProcessorFactory.class);
//                bind(LegoMarshallerServiceImpl.class).to(LegoMarshallerService.class);
//
//                // Web package implementations
//                bind(MultipartFileUtilsImpl.class).to(MultiPartFileUtils.class);

            }
        });
    }


    /**
     * Create and return an application configuration, for use in starting a jersey server.
     * @return the configuration object, which can be modified further.
     */
    public static ResourceConfig createApp(final ServiceLocator serviceLocator) {
        return new ApplicationConfig(serviceLocator);
    }

}

