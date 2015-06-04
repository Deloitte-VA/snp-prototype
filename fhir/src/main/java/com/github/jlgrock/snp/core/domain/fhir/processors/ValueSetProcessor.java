package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.core.domain.fhir.model.ValueSet;

import gov.vha.isaac.logic.LogicGraph;

import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class ValueSetProcessor extends AbstractFhirProcessor {

    private final ValueSet valueSet;

    public ValueSetProcessor(final TerminologyStoreDI terminologyStoreDIIn, final ValueSet valueSetIn) {
        super(terminologyStoreDIIn);
        valueSet = valueSetIn;
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
