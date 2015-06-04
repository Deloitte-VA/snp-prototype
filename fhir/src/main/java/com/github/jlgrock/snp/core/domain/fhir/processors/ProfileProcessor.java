package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.core.domain.fhir.model.Profile;

import gov.vha.isaac.logic.LogicGraph;

import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class ProfileProcessor extends AbstractFhirProcessor {

    private final Profile profile;

    public ProfileProcessor(final TerminologyStoreDI terminologyStoreDIIn, final Profile profileIn) {
        super(terminologyStoreDIIn);
        profile = profileIn;
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
