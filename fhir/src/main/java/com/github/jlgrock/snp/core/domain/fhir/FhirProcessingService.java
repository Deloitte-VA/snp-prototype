package com.github.jlgrock.snp.core.domain.fhir;

import com.github.jlgrock.snp.apis.exceptions.ClassifierException;
import com.github.jlgrock.snp.apis.exceptions.UnmarshallingException;
import com.github.jlgrock.snp.apis.web.MediaTypeService;
import com.github.jlgrock.snp.apis.web.ProcessingService;
import com.github.jlgrock.snp.core.domain.fhir.classifiers.FhirElementClassifierFactory;
import com.github.jlgrock.snp.core.domain.fhir.classifiers.FhirElementClassifierService;
import com.github.jlgrock.snp.core.domain.fhir.marshallers.FhirMarshallerService;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 */
@Service
public class FhirProcessingService implements ProcessingService {
    private MediaTypeService mediaType;
    private FhirElementClassifierFactory fhirElementClassifierFactory;
    private FhirMarshallerService fhirMarshallerService;

    @Inject
    public FhirProcessingService(@Named("FhirMediaTypeService") final MediaTypeService mediaTypeIn,
                          final FhirMarshallerService fhirMarshallerServiceIn,
                          final FhirElementClassifierFactory fhirElementClassifierFactoryIn) {
        mediaType = mediaTypeIn;
        fhirMarshallerService = fhirMarshallerServiceIn;
        fhirElementClassifierFactory = fhirElementClassifierFactoryIn;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void processInput(final java.lang.String input) {
        Object unmarshalledObject = null;
        try {
            unmarshalledObject = fhirMarshallerService.unmarshall(input);
        } catch(UnmarshallingException ue) {
            //TODO
        }
        if (unmarshalledObject != null) {
            FhirElementClassifierService legoElementClassifierService = null;
            try {
                legoElementClassifierService = fhirElementClassifierFactory.findClassifier(unmarshalledObject);
            } catch (ClassifierException ce) {
                //TODO
            }
            legoElementClassifierService.classify();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public java.lang.String getMediaTypeString() {
        return mediaType.getMediaTypeString();
    }

}
