package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.CarePlan;
import gov.vha.isaac.logic.LogicGraph;

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
    protected LogicGraph getLogicGraph() {
        throw new UnsupportedOperationException();
    }

	@Override
	public void process() {
		throw new UnsupportedOperationException();
		
	}

}
