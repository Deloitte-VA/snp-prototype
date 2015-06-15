package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.AllergyIntolerance;
import gov.vha.isaac.logic.LogicGraph;

/**
 *
 */
public class AllergyIntoleranceProcessor extends AbstractFhirProcessor {

    private final AllergyIntolerance allergyIntolerance;

    public AllergyIntoleranceProcessor(final LogicGraphClassifier logicGraphClassifierIn, final AllergyIntolerance allergyIntoleranceIn) {
        super(logicGraphClassifierIn);
        allergyIntolerance = allergyIntoleranceIn;
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
