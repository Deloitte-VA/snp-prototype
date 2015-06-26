package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.Condition;

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
	public void process(final String identifier) {
		throw new UnsupportedOperationException();
		
	}

}
