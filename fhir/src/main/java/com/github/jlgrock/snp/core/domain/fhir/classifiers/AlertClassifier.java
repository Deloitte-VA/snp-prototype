package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.Alert;

/**
 *
 */
public class AlertClassifier extends AbstractFhirClassifier {

    private final Alert alert;

    public AlertClassifier(final Alert alertIn) {
        alert = alertIn;
    }

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
