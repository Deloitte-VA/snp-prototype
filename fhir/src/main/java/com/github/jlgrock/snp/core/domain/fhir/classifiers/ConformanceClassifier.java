package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.Conformance;

/**
 *
 */
public class ConformanceClassifier extends AbstractFhirClassifier {

    private final Conformance conformance;

    public ConformanceClassifier(final Conformance conformanceIn) {
        conformance = conformanceIn;
    }

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
