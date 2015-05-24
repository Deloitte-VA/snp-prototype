package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.Other;

/**
 *
 */
public class OtherClassifier extends AbstractFhirClassifier {

    private final Other other;

    public OtherClassifier(final Other otherIn) {
        other = otherIn;
    }

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
