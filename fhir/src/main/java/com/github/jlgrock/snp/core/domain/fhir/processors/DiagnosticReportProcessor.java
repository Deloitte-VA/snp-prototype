package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.core.domain.fhir.model.DiagnosticReport;

import gov.vha.isaac.logic.LogicGraph;

import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class DiagnosticReportProcessor extends AbstractFhirProcessor {

    private final DiagnosticReport diagnosticReport;

    public DiagnosticReportProcessor(final TerminologyStoreDI terminologyStoreDIIn, final DiagnosticReport diagnosticReportIn) {
        super(terminologyStoreDIIn);
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
