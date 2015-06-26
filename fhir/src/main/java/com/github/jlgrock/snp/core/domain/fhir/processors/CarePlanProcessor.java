package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.CarePlan;

/**
 *
 */
public class CarePlanProcessor extends AbstractFhirProcessor {

    private final CarePlan carePlan;

    public CarePlanProcessor(final LogicGraphClassifier logicGraphClassifierIn, final CarePlan carePlanIn) {
        super(logicGraphClassifierIn);
        carePlan = carePlanIn;
    }

	@Override
	public void process(final String identifier) {
		throw new UnsupportedOperationException();
		
	}

}
