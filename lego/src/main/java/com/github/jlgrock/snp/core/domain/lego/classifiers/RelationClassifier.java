package com.github.jlgrock.snp.core.domain.lego.classifiers;

import com.github.jlgrock.snp.core.domain.lego.Relation;

/**
 *
 */
public class RelationClassifier extends AbstractLegoClassifier {

    private final Relation relation;

    RelationClassifier(final Relation relationIn) {
        relation = relationIn;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
