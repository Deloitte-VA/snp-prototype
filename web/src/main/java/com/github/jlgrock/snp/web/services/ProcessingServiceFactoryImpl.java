package com.github.jlgrock.snp.web.services;

import com.github.jlgrock.snp.apis.web.ProcessingService;
import com.github.jlgrock.snp.apis.web.ProcessingServiceFactory;
import org.glassfish.hk2.api.IterableProvider;
import org.jvnet.hk2.annotations.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

/**
 * Factory class that manages all of the marshalling details for input formats
 */
@Service
public class ProcessingServiceFactoryImpl implements ProcessingServiceFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProcessingServiceFactoryImpl.class);


    private Map<String, ProcessingService> processingServices;

    /**
     * @param processingServicesIn the list of all of the possible services that can be used
     */
    @Inject
    ProcessingServiceFactoryImpl(final IterableProvider<ProcessingService> processingServicesIn) {
        processingServices = new HashMap<>();
        for (ProcessingService processingService : processingServicesIn) {
            if (processingServices.containsKey(processingService.getMediaTypeString())) {
                LOGGER.error(
                        "Processing Service with the key '{}' has been found more than once. This should be corrected, as this needs to be unique.",
                        processingService.getMediaTypeString());
            }
            processingServices.put(processingService.getMediaTypeString(), processingService);
        }
    }

    /**
     * Find the appropriate process based on the media-type
     *
     * @param snpMediaType the media-type/mime-type to look up
     * @return the process that matches the media-type
     */
    public ProcessingService getService(final MediaType snpMediaType) {
        LOGGER.trace("finding service '{}'", snpMediaType);
        return processingServices.get(snpMediaType.getType() + "/" + snpMediaType.getSubtype());
    }
}
