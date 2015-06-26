package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.DiagnosticReport;

/**
 *
 */
public class DiagnosticReportProcessor extends AbstractFhirProcessor {

    private final DiagnosticReport diagnosticReport;

    public DiagnosticReportProcessor(final LogicGraphClassifier logicGraphClassifierIn, final DiagnosticReport diagnosticReportIn) {
        super(logicGraphClassifierIn);
        diagnosticReport = diagnosticReportIn;
    }

	@Override
	public void process(final String identifier) {
		throw new UnsupportedOperationException();
		
	}

}
