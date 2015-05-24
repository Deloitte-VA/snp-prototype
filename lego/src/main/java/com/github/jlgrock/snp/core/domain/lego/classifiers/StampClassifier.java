package com.github.jlgrock.snp.core.domain.lego.classifiers;

import com.github.jlgrock.snp.core.domain.lego.Stamp;

/**
 *
 */
public class StampClassifier extends AbstractLegoClassifier {

    private final Stamp stamp;

    StampClassifier(final Stamp stampIn) {
        stamp = stampIn;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
