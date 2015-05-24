package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.MedicationDispense;

/**
 *
 */
public class MedicationDispenseClassifier extends AbstractFhirClassifier {

    private final MedicationDispense medicationDispense;

    public MedicationDispenseClassifier(final MedicationDispense medicationDispenseIn) {
        medicationDispense = medicationDispenseIn;
    }

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
