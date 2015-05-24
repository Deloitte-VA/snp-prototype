package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.ImmunizationRecommendation;

/**
 *
 */
public class ImmunizationRecommendationClassifier extends AbstractFhirClassifier {

    private final ImmunizationRecommendation immunizationRecommendation;

    public ImmunizationRecommendationClassifier(final ImmunizationRecommendation immunizationRecommendationIn) {
        immunizationRecommendation = immunizationRecommendationIn;
    }

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
