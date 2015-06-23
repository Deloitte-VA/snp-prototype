package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.Observation;
import gov.vha.isaac.logic.LogicGraph;

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
    protected LogicGraph getLogicGraph() {
        throw new UnsupportedOperationException();
    }

	@Override
	public void process() {
		throw new UnsupportedOperationException();
		
	}
}
