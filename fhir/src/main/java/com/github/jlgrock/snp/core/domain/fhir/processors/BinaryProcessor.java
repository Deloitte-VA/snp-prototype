package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.Binary;

/**
 *
 */
public class BinaryProcessor extends AbstractFhirProcessor {

    private final Binary binary;

    public BinaryProcessor(final LogicGraphClassifier logicGraphClassifierIn, final Binary binaryIn) {
        super(logicGraphClassifierIn);
        binary = binaryIn;
    }

	@Override
	public void process(final String identifier) {
		throw new UnsupportedOperationException();
		
	}

}
