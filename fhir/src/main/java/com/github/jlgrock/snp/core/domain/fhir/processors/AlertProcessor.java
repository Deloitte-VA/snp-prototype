package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.core.domain.fhir.model.Alert;

import gov.vha.isaac.logic.LogicGraph;

import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class AlertProcessor extends AbstractFhirProcessor {

    private final Alert alert;

    public AlertProcessor(final TerminologyStoreDI terminologyStoreDIIn, final Alert alertIn) {
        super(terminologyStoreDIIn);
        alert = alertIn;
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
