package com.github.jlgrock.snp.core.domain.lego.processors;

import com.github.jlgrock.snp.domain.data.ClassifiedPceStore;
import com.github.jlgrock.snp.core.domain.lego.model.AssertionComponent;

import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class AssertionComponentProcessor extends AbstractLegoProcessor {

    private final AssertionComponent assertionComponent;

    AssertionComponentProcessor(final TerminologyStoreDI terminologyStoreDI, final ClassifiedPceStore classPceStore,
                                final AssertionComponent assertionComponentIn) {
        super(terminologyStoreDI, classPceStore);
        assertionComponent = assertionComponentIn;
    }

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
