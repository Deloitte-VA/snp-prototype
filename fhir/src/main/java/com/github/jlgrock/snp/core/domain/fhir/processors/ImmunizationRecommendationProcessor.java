package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.ImmunizationRecommendation;
import gov.vha.isaac.logic.LogicGraph;

/**
 *
 */
public class ImmunizationRecommendationProcessor extends AbstractFhirProcessor {

    private final ImmunizationRecommendation immunizationRecommendation;

    public ImmunizationRecommendationProcessor(final LogicGraphClassifier logicGraphClassifierIn, final ImmunizationRecommendation immunizationRecommendationIn) {
        super(logicGraphClassifierIn);
        immunizationRecommendation = immunizationRecommendationIn;
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
