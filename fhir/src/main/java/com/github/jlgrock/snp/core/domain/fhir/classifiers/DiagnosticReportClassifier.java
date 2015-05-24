package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.DiagnosticReport;

/**
 *
 */
public class DiagnosticReportClassifier extends AbstractFhirClassifier {

    private final DiagnosticReport diagnosticReport;

    public DiagnosticReportClassifier(final DiagnosticReport diagnosticReportIn) {
        diagnosticReport = diagnosticReportIn;
    }

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
