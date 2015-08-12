package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.exceptions.ClassifierException;
import org.glassfish.hk2.api.IterableProvider;
import org.jvnet.hk2.annotations.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

/**
 * The factory implementation for finding a specific processing service to handle an unmarshalled FHIR XML object.
 */
@Service
public class FhirElementProcessorFactoryImpl implements FhirElementProcessorFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(FhirElementProcessorFactoryImpl.class);

    private final Map<Class, FhirElementProcessorService> processingServices;

    @Inject
    FhirElementProcessorFactoryImpl(final IterableProvider<FhirElementProcessorService> processingServicesIn) {
        processingServices = new HashMap<>();
        processingServicesIn.forEach(processingService -> processingServices.put(processingService.processesType(), processingService));
    }

    @Override
    public FhirElementProcessorService findProcessingService(final Object unmarshalledObject) throws ClassifierException {
        LOGGER.trace("determining fhir element processor service...");

        FhirElementProcessorService fhirElementProcessorService = processingServices.get(unmarshalledObject.getClass());
        if (fhirElementProcessorService == null) {
            throw new ClassifierException("Could not parse unmarshalled object for class ["
                    + unmarshalledObject.getClass().getName() + "].  Are you sure this is a fhir document?");
        }
        return fhirElementProcessorService;
    }
}
