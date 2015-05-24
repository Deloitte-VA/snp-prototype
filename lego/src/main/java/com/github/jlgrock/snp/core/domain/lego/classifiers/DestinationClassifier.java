package com.github.jlgrock.snp.core.domain.lego.classifiers;

import com.github.jlgrock.snp.core.domain.lego.Destination;

/**
 *
 */
public class DestinationClassifier extends AbstractLegoClassifier {

    private final Destination destination;

    DestinationClassifier(final Destination destinationIn) {
        destination = destinationIn;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void classify() {
        parseDestination(destination);
    }
}
