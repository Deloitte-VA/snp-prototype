package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.Other;
import gov.vha.isaac.logic.LogicGraph;

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
    protected LogicGraph getLogicGraph() {
        throw new UnsupportedOperationException();
    }

	@Override
	public void process() {
		throw new UnsupportedOperationException();
		
	}
}
