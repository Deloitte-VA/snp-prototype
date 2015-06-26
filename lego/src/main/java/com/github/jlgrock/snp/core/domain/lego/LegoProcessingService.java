package com.github.jlgrock.snp.core.domain.lego;

import com.github.jlgrock.snp.apis.exceptions.ClassifierException;
import com.github.jlgrock.snp.apis.exceptions.UnmarshallingException;
import com.github.jlgrock.snp.apis.web.ProcessingService;
import com.github.jlgrock.snp.core.domain.lego.marhsallers.LegoMarshallerService;
import com.github.jlgrock.snp.core.domain.lego.processors.LegoElementProcessorFactory;
import com.github.jlgrock.snp.core.domain.lego.processors.LegoElementProcessorService;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;

/**
 *
 */
@Service
public class LegoProcessingService implements ProcessingService {

    private LegoMediaTypeService legoMediaType;
    private LegoMarshallerService legoMarshallerService;
    private LegoElementProcessorFactory legoElementProcessorFactory;

    @Inject
    public LegoProcessingService(final LegoMediaTypeService legoMediaTypeIn,
                                 final LegoMarshallerService legoMarshallerServiceIn,
                                 final LegoElementProcessorFactory legoElementProcessorFactoryIn) {
        legoMediaType = legoMediaTypeIn;
        legoMarshallerService = legoMarshallerServiceIn;
        legoElementProcessorFactory = legoElementProcessorFactoryIn;
    }

    /**
     * @{@inheritDoc}
     *
     * This ignores the identifier parameter
     */
    @Override
    public void processInput(final String input, final String identifier) {
        Object unmarshalledObject = null;
        try {
            unmarshalledObject = legoMarshallerService.unmarshall(input);
        } catch(UnmarshallingException ue) {
            //TODO
        }
        if (unmarshalledObject != null) {
            LegoElementProcessorService legoElementProcessorService = null;
            try {
                legoElementProcessorService = legoElementProcessorFactory.findElementProcessor(unmarshalledObject);
            } catch (ClassifierException ce) {
                //TODO
            }
            legoElementProcessorService.process();
        }
    }

    @Override
    public String getMediaTypeString() {
        return legoMediaType.getMediaTypeString();
    }
}
