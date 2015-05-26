package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.ImmunizationRecommendation;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class ImmunizationRecommendationClassifier extends AbstractFhirClassifier {

    private final ImmunizationRecommendation immunizationRecommendation;

    public ImmunizationRecommendationClassifier(final TerminologyStoreDI terminologyStoreDIIn, final ImmunizationRecommendation immunizationRecommendationIn) {
        super(terminologyStoreDIIn);
        immunizationRecommendation = immunizationRecommendationIn;
    }

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
