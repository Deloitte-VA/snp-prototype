package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.core.domain.fhir.model.Substance;

import gov.vha.isaac.logic.LogicGraph;

import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class SubstanceProcessor extends AbstractFhirProcessor {

    private final Substance substance;

    public SubstanceProcessor(final TerminologyStoreDI terminologyStoreDIIn, final Substance substanceIn) {
        super(terminologyStoreDIIn);
        substance = substanceIn;
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
