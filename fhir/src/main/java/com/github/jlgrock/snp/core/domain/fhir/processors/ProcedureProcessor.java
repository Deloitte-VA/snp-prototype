package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.core.domain.fhir.model.Procedure;

import gov.vha.isaac.logic.LogicGraph;

import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class ProcedureProcessor extends AbstractFhirProcessor {

    private final Procedure procedure;

    public ProcedureProcessor(final TerminologyStoreDI terminologyStoreDIIn, final Procedure procedureIn) {
        super(terminologyStoreDIIn);
        procedure = procedureIn;
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
