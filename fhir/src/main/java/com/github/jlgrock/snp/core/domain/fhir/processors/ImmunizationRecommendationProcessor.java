package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.ImmunizationRecommendation;

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
	public void process(final String identifier) {
		throw new UnsupportedOperationException();
		
	}
}
