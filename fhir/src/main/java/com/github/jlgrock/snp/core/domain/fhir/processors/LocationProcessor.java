package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.Location;
import gov.vha.isaac.logic.LogicGraph;

/**
 *
 */
public class LocationProcessor extends AbstractFhirProcessor {

    private final Location location;

    public LocationProcessor(final LogicGraphClassifier logicGraphClassifierIn, final Location locationIn) {
        super(logicGraphClassifierIn);
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
