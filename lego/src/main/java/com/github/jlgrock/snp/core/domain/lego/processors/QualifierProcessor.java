package com.github.jlgrock.snp.core.domain.lego.processors;

import com.github.jlgrock.snp.domain.data.ClassifiedPceStore;
import com.github.jlgrock.snp.core.domain.lego.model.Qualifier;

import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class QualifierProcessor extends AbstractLegoProcessor {

    private final Qualifier qualifier;

    QualifierProcessor(final TerminologyStoreDI terminologyStoreDI, final ClassifiedPceStore classPceStore,
                       final Qualifier qualifierIn) {
        super(terminologyStoreDI, classPceStore);
        qualifier = qualifierIn;
    }

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
