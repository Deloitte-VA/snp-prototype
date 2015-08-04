package com.github.jlgrock.snp.core.domain.fhir;

import com.github.jlgrock.snp.apis.exceptions.ClassifierException;
import com.github.jlgrock.snp.apis.exceptions.ProcessingException;
import com.github.jlgrock.snp.apis.exceptions.UnmarshallingException;
import com.github.jlgrock.snp.apis.web.ProcessingService;
import com.github.jlgrock.snp.core.domain.fhir.marshallers.FhirMarshallerService;
import com.github.jlgrock.snp.core.domain.fhir.processors.FhirElementProcessorFactory;
import com.github.jlgrock.snp.core.domain.fhir.processors.FhirElementProcessorService;

import org.jvnet.hk2.annotations.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

/**
 *
 */
@Service
public class FhirProcessingService implements ProcessingService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FhirProcessingService.class);

    private FhirMediaTypeService fhirMediaTypeService;
    private FhirElementProcessorFactory fhirElementProcessorFactory;
    private FhirMarshallerService fhirMarshallerService;

    @Inject
    public FhirProcessingService(final FhirMediaTypeService fhirMediaTypeServiceIn,
                          final FhirMarshallerService fhirMarshallerServiceIn,
                          final FhirElementProcessorFactory fhirElementProcessorFactoryIn) {
        fhirMediaTypeService = fhirMediaTypeServiceIn;
        fhirMarshallerService = fhirMarshallerServiceIn;
        fhirElementProcessorFactory = fhirElementProcessorFactoryIn;
    }

    @Override
    public void processInput(final String input, final String identifier) throws ProcessingException {
        LOGGER.trace("Processing Input for fhir...");
        Object unmarshalledObject = null;
        try {
            unmarshalledObject = fhirMarshallerService.unmarshall(input);
        } catch(UnmarshallingException ue) {
        	String errMsg = "Unable to unmarshall object";
            LOGGER.error(errMsg, ue);
            throw new ProcessingException(errMsg, ue);
        }
        if (unmarshalledObject != null) {
            FhirElementProcessorService legoElementClassifierService = null;
            try {
                legoElementClassifierService = fhirElementProcessorFactory.findClassifier(unmarshalledObject);
            } catch (ClassifierException ce) {
            	String errMsg = "Unable to find processor";
                LOGGER.error(errMsg, ce);
                throw new ProcessingException(errMsg, ce);
            }
            legoElementClassifierService.process(identifier, unmarshalledObject);
        }
    }

    @Override
    public String getMediaTypeString() {
        return fhirMediaTypeService.getMediaTypeString();
    }

}
