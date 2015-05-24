package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.MedicationPrescription;

/**
 *
 */
public class MedicationPrescriptionClassifier extends AbstractFhirClassifier {

    private final MedicationPrescription medicationPrescription;

    public MedicationPrescriptionClassifier(final MedicationPrescription medicationPrescriptionIn) {
        medicationPrescription = medicationPrescriptionIn;
    }

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
