package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.Alert;

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
	public void process(final String identifier) {
		throw new UnsupportedOperationException();
		
	}

}
