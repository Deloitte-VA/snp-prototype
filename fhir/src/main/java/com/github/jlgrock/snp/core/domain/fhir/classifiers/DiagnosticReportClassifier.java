package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.DiagnosticReport;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class DiagnosticReportClassifier extends AbstractFhirClassifier {

    private final DiagnosticReport diagnosticReport;

    public DiagnosticReportClassifier(final TerminologyStoreDI terminologyStoreDIIn, final DiagnosticReport diagnosticReportIn) {
        super(terminologyStoreDIIn);
        diagnosticReport = diagnosticReportIn;
    }

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
