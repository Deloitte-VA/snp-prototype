package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.Condition;
import gov.vha.isaac.logic.LogicGraph;

/**
 *
 */
public class ConditionProcessor extends AbstractFhirProcessor {

    private final Condition condition;

    public ConditionProcessor(final LogicGraphClassifier logicGraphClassifierIn, final Condition conditionIn) {
        super(logicGraphClassifierIn);
        condition = conditionIn;
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
