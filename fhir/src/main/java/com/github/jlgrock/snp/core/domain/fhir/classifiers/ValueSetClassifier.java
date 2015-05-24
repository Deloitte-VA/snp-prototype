package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.ValueSet;

/**
 *
 */
public class ValueSetClassifier extends AbstractFhirClassifier {

    private final ValueSet valueSet;

    public ValueSetClassifier(final ValueSet valueSetIn) {
        valueSet = valueSetIn;
    }

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
