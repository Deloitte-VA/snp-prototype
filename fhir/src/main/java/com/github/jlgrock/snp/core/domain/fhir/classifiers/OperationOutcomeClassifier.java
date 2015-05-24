package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.OperationOutcome;

/**
 *
 */
public class OperationOutcomeClassifier extends AbstractFhirClassifier {

    private final OperationOutcome operationOutcome;

    public OperationOutcomeClassifier(final OperationOutcome operationOutcomeIn) {
        operationOutcome = operationOutcomeIn;
    }

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
