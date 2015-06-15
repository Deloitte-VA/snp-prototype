package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.ValueSet;
import gov.vha.isaac.logic.LogicGraph;

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
    protected LogicGraph getLogicGraph() {
        throw new UnsupportedOperationException();
    }

	@Override
	public void process() {
		throw new UnsupportedOperationException();
		
	}
}
