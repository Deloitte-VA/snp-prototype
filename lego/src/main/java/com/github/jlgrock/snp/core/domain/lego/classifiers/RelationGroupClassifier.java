package com.github.jlgrock.snp.core.domain.lego.classifiers;

import com.github.jlgrock.snp.core.domain.lego.RelationGroup;

/**
 *
 */
public class RelationGroupClassifier extends AbstractLegoClassifier {

    private final RelationGroup relationGroup;

    RelationGroupClassifier(final RelationGroup relationGroupIn) {
        relationGroup = relationGroupIn;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
