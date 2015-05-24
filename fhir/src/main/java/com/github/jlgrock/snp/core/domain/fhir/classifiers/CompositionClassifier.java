package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.Composition;

/**
 *
 */
public class CompositionClassifier extends AbstractFhirClassifier {

    private final Composition composition;

    public CompositionClassifier(final Composition compositionIn) {
        composition = compositionIn;
    }

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
