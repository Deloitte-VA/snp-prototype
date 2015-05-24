package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.MedicationStatement;

/**
 *
 */
public class MedicationStatementClassifier extends AbstractFhirClassifier {

    private final MedicationStatement medicationStatement;

    public MedicationStatementClassifier(final MedicationStatement medicationStatementIn) {
        medicationStatement = medicationStatementIn;
    }

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
