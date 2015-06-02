package com.github.jlgrock.snp.core.domain.fhir;

import com.github.jlgrock.snp.apis.exceptions.ClassifierException;
import com.github.jlgrock.snp.apis.exceptions.UnmarshallingException;
import com.github.jlgrock.snp.apis.web.MediaTypeService;
import com.github.jlgrock.snp.apis.web.ProcessingService;
import com.github.jlgrock.snp.core.domain.fhir.marshallers.FhirMarshallerService;
import com.github.jlgrock.snp.core.domain.fhir.processors.FhirElementProcessorFactory;
import com.github.jlgrock.snp.core.domain.fhir.processors.FhirElementProcessorFactoryImpl;
import com.github.jlgrock.snp.core.domain.fhir.processors.FhirElementProcessorService;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 */
@Service
public class FhirProcessingService implements ProcessingService {
    private MediaTypeService mediaType;
    private FhirElementProcessorFactory fhirElementProcessorFactory;
    private FhirMarshallerService fhirMarshallerService;

    @Inject
    public FhirProcessingService(@Named("FhirMediaTypeService") final MediaTypeService mediaTypeIn,
                          final FhirMarshallerService fhirMarshallerServiceIn,
                          final FhirElementProcessorFactoryImpl fhirElementProcessorFactoryIn) {
        mediaType = mediaTypeIn;
        fhirMarshallerService = fhirMarshallerServiceIn;
        fhirElementProcessorFactory = fhirElementProcessorFactoryIn;
    }

    @Override
    public void processInput(final java.lang.String input) {
        Object unmarshalledObject = null;
        try {
            unmarshalledObject = fhirMarshallerService.unmarshall(input);
        } catch(UnmarshallingException ue) {
            //TODO
        }
        if (unmarshalledObject != null) {
            FhirElementProcessorService legoElementClassifierService = null;
            try {
                legoElementClassifierService = fhirElementProcessorFactory.findClassifier(unmarshalledObject);
            } catch (ClassifierException ce) {
                //TODO
            }
            legoElementClassifierService.classify();
        }
    }

    @Override
    public java.lang.String getMediaTypeString() {
        return mediaType.getMediaTypeString();
    }

}
