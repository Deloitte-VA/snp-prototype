package com.github.jlgrock.snp.core.domain.lego.classifiers;

import com.github.jlgrock.snp.core.domain.lego.Value;

/**
 *
 */
public class ValueClassifier extends AbstractLegoClassifier {

    private final Value value;

    ValueClassifier(final Value valueIn) {
        value = valueIn;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
