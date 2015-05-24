package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.DiagnosticOrder;

/**
 *
 */
public class DiagnosticOrderClassifier extends AbstractFhirClassifier {

    private final DiagnosticOrder diagnosticOrder;

    public DiagnosticOrderClassifier(final DiagnosticOrder diagnosticOrderIn) {
        diagnosticOrder = diagnosticOrderIn;
    }

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
