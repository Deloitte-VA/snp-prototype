package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.DiagnosticReport;
import gov.vha.isaac.logic.LogicGraph;

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
    protected LogicGraph getLogicGraph() {
        throw new UnsupportedOperationException();
    }

	@Override
	public void process() {
		throw new UnsupportedOperationException();
		
	}

}
