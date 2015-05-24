package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.FamilyHistory;

/**
 *
 */
public class FamilyHistoryClassifier extends AbstractFhirClassifier {

    private final FamilyHistory familyHistory;

    public FamilyHistoryClassifier(final FamilyHistory familyHistoryIn) {
        familyHistory = familyHistoryIn;
    }

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
