package com.github.jlgrock.snp.core.domain.lego.classifiers;

import com.github.jlgrock.snp.core.domain.lego.Concept;

/**
 *
 */
public class ConceptClassifier extends AbstractLegoClassifier {

    private final Concept concept;

    ConceptClassifier(final Concept conceptIn) {
        concept = conceptIn;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
