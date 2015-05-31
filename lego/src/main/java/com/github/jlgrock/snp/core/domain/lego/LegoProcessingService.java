package com.github.jlgrock.snp.core.domain.lego;

import com.github.jlgrock.snp.apis.exceptions.ClassifierException;
import com.github.jlgrock.snp.apis.exceptions.UnmarshallingException;
import com.github.jlgrock.snp.apis.web.MediaTypeService;
import com.github.jlgrock.snp.apis.web.ProcessingService;
import com.github.jlgrock.snp.core.domain.lego.processors.LegoElementProcessorFactory;
import com.github.jlgrock.snp.core.domain.lego.processors.LegoElementProcessorService;
import com.github.jlgrock.snp.core.domain.lego.marhsallers.LegoMarshallerService;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 */
@Service
public class LegoProcessingService implements ProcessingService {

    private MediaTypeService mediaType;
    private LegoMarshallerService legoMarshallerService;
    private LegoElementProcessorFactory legoElementProcessorFactory;

    @Inject
    public LegoProcessingService(@Named("LegoMediaTypeService") final MediaTypeService mediaTypeIn,
                                 final LegoMarshallerService legoMarshallerServiceIn,
                                 final LegoElementProcessorFactory legoElementProcessorFactoryIn) {
        mediaType = mediaTypeIn;
        legoMarshallerService = legoMarshallerServiceIn;
        legoElementProcessorFactory = legoElementProcessorFactoryIn;
    }

    @Override
    public void processInput(final String input) {
        Object unmarshalledObject = null;
        try {
            unmarshalledObject = legoMarshallerService.unmarshall(input);
        } catch(UnmarshallingException ue) {
            //TODO
        }
        if (unmarshalledObject != null) {
            LegoElementProcessorService legoElementProcessorService = null;
            try {
                legoElementProcessorService = legoElementProcessorFactory.findClassifier(unmarshalledObject);
            } catch (ClassifierException ce) {
                //TODO
            }
            legoElementProcessorService.classify();
        }
    }

    @Override
    public String getMediaTypeString() {
        return mediaType.getMediaTypeString();
    }
}
