package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.OperationOutcome;

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
	public void process(final String identifier) {
		throw new UnsupportedOperationException();
		
	}
}
