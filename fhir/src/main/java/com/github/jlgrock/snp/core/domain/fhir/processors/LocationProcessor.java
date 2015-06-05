package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.core.domain.fhir.model.Location;

import gov.vha.isaac.logic.LogicGraph;

import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class LocationProcessor extends AbstractFhirProcessor {

    private final Location location;

    public LocationProcessor(final TerminologyStoreDI terminologyStoreDIIn, final Location locationIn) {
        super(terminologyStoreDIIn);
        location = locationIn;
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
