package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.Location;

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
	public void process(final String identifier) {
		throw new UnsupportedOperationException();
		
	}
}
