package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.Other;

/**
 *
 */
public class OtherProcessor extends AbstractFhirProcessor {

    private final Other other;

    public OtherProcessor(final LogicGraphClassifier logicGraphClassifierIn, final Other otherIn) {
        super(logicGraphClassifierIn);
        other = otherIn;
    }

	@Override
	public void process(final String identifier) {
		throw new UnsupportedOperationException();
		
	}
}
