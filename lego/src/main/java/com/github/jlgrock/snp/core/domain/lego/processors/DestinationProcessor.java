package com.github.jlgrock.snp.core.domain.lego.processors;

import com.github.jlgrock.snp.domain.data.ClassifiedPceStore;
import com.github.jlgrock.snp.core.domain.lego.model.Destination;

import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class DestinationProcessor extends AbstractLegoProcessor {

    private final Destination destination;

    DestinationProcessor(final TerminologyStoreDI terminologyStoreDI, final ClassifiedPceStore classPceStore,
                         final Destination destinationIn) {
        super(terminologyStoreDI, classPceStore);
        destination = destinationIn;
    }

    @Override
    public void classify() {
        parseDestination(destination);
    }
}
