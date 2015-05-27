package com.github.jlgrock.snp.core.domain.lego.classifiers;

import com.github.jlgrock.snp.core.data.ClassifiedPceStore;
import com.github.jlgrock.snp.core.domain.lego.AssertionComponent;

import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class AssertionComponentClassifier extends AbstractLegoClassifier {

    private final AssertionComponent assertionComponent;

    AssertionComponentClassifier(final TerminologyStoreDI terminologyStoreDI, final ClassifiedPceStore classPceStore,
    		final AssertionComponent assertionComponentIn) {
        super(terminologyStoreDI, classPceStore);
        assertionComponent = assertionComponentIn;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
