package com.github.jlgrock.snp.core.domain.lego.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.lego.model.Destination;
import com.github.jlgrock.snp.domain.data.ClassifiedPceStore;

/**
 *
 */
public class DestinationProcessor extends AbstractLegoProcessor {

    private final Destination destination;

    DestinationProcessor(final LogicGraphClassifier logicGraphClassifierIn, final ClassifiedPceStore classPceStore,
                         final Destination destinationIn) {
        super(logicGraphClassifierIn, classPceStore);
        destination = destinationIn;
    }

    @Override
    public void process() {
        processDestination(destination);
    }
}
