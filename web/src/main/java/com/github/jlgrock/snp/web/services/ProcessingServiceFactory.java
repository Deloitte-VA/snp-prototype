package com.github.jlgrock.snp.web.services;

import com.github.jlgrock.snp.apis.web.ProcessingService;
import org.glassfish.hk2.api.IterableProvider;
import org.jvnet.hk2.annotations.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.core.MediaType;
import java.util.Map;

/**
 * Factory class that manages all of the marshalling details for input formats
 */
@Service
public class ProcessingServiceFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProcessingServiceFactory.class);


    private Map<String, ProcessingService> processingServices;

    @Inject
    ProcessingServiceFactory(final IterableProvider<ProcessingService> processingServicesIn) {
        for (ProcessingService processingService : processingServicesIn) {
            if (processingServices.containsKey(processingService.getMediaTypeString())) {
                LOGGER.error("Processing Service with the key '{}' has been found more than once.  This should be corrected, as this needs to be unique.");
            }
            processingServices.put(processingService.getMediaTypeString(), processingService);
        }
    }

    public ProcessingService getService(final MediaType snpMediaType) {
        return processingServices.get(snpMediaType.getType() + "/" + snpMediaType.getSubtype());
    }
}
