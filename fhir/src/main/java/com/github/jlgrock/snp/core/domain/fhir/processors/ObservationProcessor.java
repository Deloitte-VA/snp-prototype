package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.Observation;

/**
 *
 */
public class ObservationProcessor extends AbstractFhirProcessor {

    private final Observation observation;

    public ObservationProcessor(final LogicGraphClassifier logicGraphClassifierIn, final Observation observationIn) {
        super(logicGraphClassifierIn);
        observation = observationIn;
    }

	@Override
	public void process(final String identifier) {
		throw new UnsupportedOperationException();
		
	}
}
