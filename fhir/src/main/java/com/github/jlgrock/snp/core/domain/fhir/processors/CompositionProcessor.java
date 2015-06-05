package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.core.domain.fhir.model.Composition;

import gov.vha.isaac.logic.LogicGraph;

import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class CompositionProcessor extends AbstractFhirProcessor {

    private final Composition composition;

    public CompositionProcessor(final TerminologyStoreDI terminologyStoreDIIn, final Composition compositionIn) {
        super(terminologyStoreDIIn);
        composition = compositionIn;
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
