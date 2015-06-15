package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.Alert;
import gov.vha.isaac.logic.LogicGraph;

/**
 *
 */
public class AlertProcessor extends AbstractFhirProcessor {

    private final Alert alert;

    public AlertProcessor(final LogicGraphClassifier logicGraphClassifierIn, final Alert alertIn) {
        super(logicGraphClassifierIn);
        alert = alertIn;
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
