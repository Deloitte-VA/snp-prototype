package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.core.domain.fhir.model.Provenance;

import gov.vha.isaac.logic.LogicGraph;

import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class ProvenanceProcessor extends AbstractFhirProcessor {

    private final Provenance provenance;

    public ProvenanceProcessor(final TerminologyStoreDI terminologyStoreDIIn, final Provenance provenanceIn) {
        super(terminologyStoreDIIn);
        provenance = provenanceIn;
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
