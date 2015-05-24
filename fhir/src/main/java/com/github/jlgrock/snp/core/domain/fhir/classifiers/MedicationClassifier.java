package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.Medication;

/**
 *
 */
public class MedicationClassifier extends AbstractFhirClassifier {

    private final Medication medication;

    public MedicationClassifier(final Medication medicationIn) {
        medication = medicationIn;
    }

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
