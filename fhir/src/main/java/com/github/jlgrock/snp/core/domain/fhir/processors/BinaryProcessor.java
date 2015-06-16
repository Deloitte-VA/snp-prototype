package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.Binary;
import gov.vha.isaac.logic.LogicGraph;

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
    protected LogicGraph getLogicGraph() {
        throw new UnsupportedOperationException();
    }

	@Override
	public void process() {
		throw new UnsupportedOperationException();
		
	}

}
