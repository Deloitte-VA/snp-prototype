package com.github.jlgrock.snp.core.domain.lego.processors;

import com.github.jlgrock.snp.apis.exceptions.ClassifierException;
import org.glassfish.hk2.api.IterableProvider;
import org.jvnet.hk2.annotations.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

@Service
public class LegoElementProcessorFactoryImpl implements LegoElementProcessorFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(LegoElementProcessorFactoryImpl.class);

    private final Map<Class, LegoElementProcessorService> processingServices;

    @Inject
    LegoElementProcessorFactoryImpl(final IterableProvider<LegoElementProcessorService> processingServicesIn) {
        LOGGER.debug("initializing processing factory.  There are a total of {} processes", processingServicesIn.getSize());
        processingServices = new HashMap<>();
        processingServicesIn.forEach(processingService -> {
                LOGGER.debug("adding '{}' to the processor stack", processingService.getClass().getName());
                processingServices.put(processingService.processesType(), processingService);
        });
    }

    @Override
    public LegoElementProcessorService findElementProcessor(final Object unmarshalledObject) throws ClassifierException {
        LOGGER.trace("determining lego element processor service...");

        LegoElementProcessorService legoElementProcessorService = processingServices.get(unmarshalledObject.getClass());
        if (legoElementProcessorService == null) {
            throw new ClassifierException("Could not parse unmarshalled object.  Are you sure this is a lego document?");
        }
        return legoElementProcessorService;
    }
}
