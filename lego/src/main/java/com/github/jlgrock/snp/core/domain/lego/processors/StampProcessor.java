package com.github.jlgrock.snp.core.domain.lego.processors;

import com.github.jlgrock.snp.domain.data.ClassifiedPceStore;
import com.github.jlgrock.snp.core.domain.lego.model.Stamp;

import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class StampProcessor extends AbstractLegoProcessor {

    private final Stamp stamp;

    StampProcessor(final TerminologyStoreDI terminologyStoreDI, final ClassifiedPceStore classPceStore,
                   final Stamp stampIn) {
        super(terminologyStoreDI, classPceStore);
        stamp = stampIn;
    }

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
