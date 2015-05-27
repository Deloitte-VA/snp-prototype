package com.github.jlgrock.snp.core.domain.lego.classifiers;

import com.github.jlgrock.snp.core.data.ClassifiedPceStore;
import com.github.jlgrock.snp.core.domain.lego.Destination;

import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class DestinationClassifier extends AbstractLegoClassifier {

    private final Destination destination;

    DestinationClassifier(final TerminologyStoreDI terminologyStoreDI, final ClassifiedPceStore classPceStore,
    		final Destination destinationIn) {
        super(terminologyStoreDI, classPceStore);
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
