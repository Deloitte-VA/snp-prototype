package com.github.jlgrock.snp.core.domain.lego.processors;

import com.github.jlgrock.snp.apis.classifier.LogicalExpressionClassifier;
import com.github.jlgrock.snp.core.domain.lego.model.Destination;
import com.github.jlgrock.snp.domain.data.ClassifiedPceRepository;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;

@Service
public class DestinationProcessor extends AbstractLegoProcessor {

    @Inject
    DestinationProcessor(final LogicalExpressionClassifier logicalExpressionClassifierIn,
                         final ClassifiedPceRepository classifiedPceRepositoryIn) {
        super(logicalExpressionClassifierIn, classifiedPceRepositoryIn);
    }

    @Override
    public void process(final Object unmarshalledObject) {
        Destination destination = (Destination) unmarshalledObject;
        processDestination(destination);
    }

    @Override
    public Class processesType() {
        return Destination.class;
    }
}
