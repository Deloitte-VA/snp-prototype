package com.github.jlgrock.snp.core.domain.lego.classifiers;

import com.github.jlgrock.snp.core.domain.lego.AssertionComponent;

/**
 *
 */
public class AssertionComponentClassifier extends AbstractLegoClassifier {

    private final AssertionComponent assertionComponent;

    AssertionComponentClassifier(final AssertionComponent assertionComponentIn) {
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
