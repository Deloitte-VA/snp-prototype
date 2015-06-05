package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.core.domain.fhir.model.Other;

import gov.vha.isaac.logic.LogicGraph;

import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class OtherProcessor extends AbstractFhirProcessor {

    private final Other other;

    public OtherProcessor(final TerminologyStoreDI terminologyStoreDIIn, final Other otherIn) {
        super(terminologyStoreDIIn);
        other = otherIn;
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
