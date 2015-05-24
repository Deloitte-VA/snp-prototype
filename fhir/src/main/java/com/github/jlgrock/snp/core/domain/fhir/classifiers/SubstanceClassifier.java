package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.Substance;

/**
 *
 */
public class SubstanceClassifier extends AbstractFhirClassifier {

    private final Substance substance;

    public SubstanceClassifier(final Substance substanceIn) {
        substance = substanceIn;
    }

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
