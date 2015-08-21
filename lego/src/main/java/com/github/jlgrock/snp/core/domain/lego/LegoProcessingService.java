package com.github.jlgrock.snp.core.domain.lego;

import com.github.jlgrock.snp.apis.exceptions.ClassifierException;
import com.github.jlgrock.snp.apis.exceptions.ProcessingException;
import com.github.jlgrock.snp.apis.exceptions.UnmarshallingException;
import com.github.jlgrock.snp.apis.web.ProcessingService;
import com.github.jlgrock.snp.core.domain.lego.marhsallers.LegoMarshallerService;
import com.github.jlgrock.snp.core.domain.lego.processors.LegoElementProcessorFactory;
import com.github.jlgrock.snp.core.domain.lego.processors.LegoElementProcessorService;

import org.jvnet.hk2.annotations.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

/**
 *
 */
@Service
public class LegoProcessingService implements ProcessingService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LegoProcessingService.class);

    private LegoMediaTypeService legoMediaType;
    private LegoMarshallerService legoMarshallerService;
    private LegoElementProcessorFactory legoElementProcessorFactory;

    /**
     * Constructor.
     * @param legoMediaTypeIn the media type that this processor can handle
     * @param legoMarshallerServiceIn the unmarshaller used for converting xml into java objects
     * @param legoElementProcessorFactoryIn the factory for determining what processor should be used for the java
     *                                      object created by the fhir marshaller
     */
    @Inject
    public LegoProcessingService(final LegoMediaTypeService legoMediaTypeIn,
                                 final LegoMarshallerService legoMarshallerServiceIn,
                                 final LegoElementProcessorFactory legoElementProcessorFactoryIn) {
        legoMediaType = legoMediaTypeIn;
        legoMarshallerService = legoMarshallerServiceIn;
        legoElementProcessorFactory = legoElementProcessorFactoryIn;
    }

    /**
     * @throws ProcessingException 
     * {@inheritDoc}
     *
     * This ignores the identifier parameter
     */
    @Override
    public void processInput(final String input, final String identifier) throws ProcessingException {
        Object unmarshalledObject = null;
        try {
            unmarshalledObject = legoMarshallerService.unmarshall(input);
        } catch (UnmarshallingException ue) {
        	String errMsg = "Unable to unmarshall object";
            LOGGER.error(errMsg, ue);
        	throw new ProcessingException(errMsg, ue);
        }
        if (unmarshalledObject != null) {
            LegoElementProcessorService legoElementProcessorService = null;
            try {
                legoElementProcessorService = legoElementProcessorFactory.findElementProcessor(unmarshalledObject);
            } catch (ClassifierException ce) {
            	String errMsg = "Unable to find classifier";
            	LOGGER.error(errMsg, ce);
            	throw new ProcessingException(errMsg, ce);
            }
            legoElementProcessorService.process(unmarshalledObject);
        }
    }

    @Override
    public String getMediaTypeString() {
        return legoMediaType.getMediaTypeString();
    }
}
