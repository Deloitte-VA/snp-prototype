package com.github.jlgrock.snp.core.domain.lego.classifiers;

import com.github.jlgrock.snp.core.domain.lego.Qualifier;

/**
 *
 */
public class QualifierClassifier extends AbstractLegoClassifier {

    private final Qualifier qualifier;

    QualifierClassifier(final Qualifier qualifierIn) {
        qualifier = qualifierIn;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
