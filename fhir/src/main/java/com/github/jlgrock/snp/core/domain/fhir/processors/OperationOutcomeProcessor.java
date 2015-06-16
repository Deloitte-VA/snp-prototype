package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.OperationOutcome;
import gov.vha.isaac.logic.LogicGraph;

/**
 *
 */
public class OperationOutcomeProcessor extends AbstractFhirProcessor {

    private final OperationOutcome operationOutcome;

    public OperationOutcomeProcessor(final LogicGraphClassifier logicGraphClassifierIn, final OperationOutcome operationOutcomeIn) {
        super(logicGraphClassifierIn);
        operationOutcome = operationOutcomeIn;
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
