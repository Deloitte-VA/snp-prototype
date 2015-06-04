package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.core.domain.fhir.model.DiagnosticOrder;

import gov.vha.isaac.logic.LogicGraph;

import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class DiagnosticOrderProcessor extends AbstractFhirProcessor {

    private final DiagnosticOrder diagnosticOrder;

    public DiagnosticOrderProcessor(final TerminologyStoreDI terminologyStoreDIIn, final DiagnosticOrder diagnosticOrderIn) {
        super(terminologyStoreDIIn);
        diagnosticOrder = diagnosticOrderIn;
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
