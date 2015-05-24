package com.github.jlgrock.snp.core.domain.lego.classifiers;

import com.github.jlgrock.snp.core.domain.lego.Type;

/**
 *
 */
public class TypeClassifier extends AbstractLegoClassifier {

    private final Type type;

    TypeClassifier(final Type typeIn) {
        type = typeIn;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
