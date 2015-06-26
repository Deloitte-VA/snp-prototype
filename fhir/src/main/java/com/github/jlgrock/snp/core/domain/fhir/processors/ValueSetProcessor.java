package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.ValueSet;

/**
 *
 */
public class ValueSetProcessor extends AbstractFhirProcessor {

    private final ValueSet valueSet;

    public ValueSetProcessor(final LogicGraphClassifier logicGraphClassifierIn, final ValueSet valueSetIn) {
        super(logicGraphClassifierIn);
        valueSet = valueSetIn;
    }

	@Override
	public void process(final String identifier) {
		throw new UnsupportedOperationException();
		
	}
}
