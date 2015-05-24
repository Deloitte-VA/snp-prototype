package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.MedicationAdministration;

/**
 *
 */
public class MedicationAdministractionClassifier extends AbstractFhirClassifier {

    private final MedicationAdministration medicationAdministration;

    public MedicationAdministractionClassifier(final MedicationAdministration medicationAdministrationIn) {
        medicationAdministration = medicationAdministrationIn;
    }

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
