package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.FamilyHistory;
import gov.vha.isaac.logic.LogicGraph;

/**
 *
 */
public class FamilyHistoryProcessor extends AbstractFhirProcessor {

    private final FamilyHistory familyHistory;

    public FamilyHistoryProcessor(final LogicGraphClassifier logicGraphClassifierIn, final FamilyHistory familyHistoryIn) {
        super(logicGraphClassifierIn);
        familyHistory = familyHistoryIn;
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
