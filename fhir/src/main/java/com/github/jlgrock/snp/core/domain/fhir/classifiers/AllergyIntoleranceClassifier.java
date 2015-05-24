package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.AllergyIntolerance;

/**
 *
 */
public class AllergyIntoleranceClassifier extends AbstractFhirClassifier {

    private final AllergyIntolerance allergyIntolerance;

    public AllergyIntoleranceClassifier(final AllergyIntolerance allergyIntoleranceIn) {
        allergyIntolerance = allergyIntoleranceIn;
    }

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
