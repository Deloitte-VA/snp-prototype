package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.Patient;

/**
 *
 */
public class PatientClassifier extends AbstractFhirClassifier {

    private final Patient patient;

    public PatientClassifier(final Patient patientIn) {
        patient = patientIn;
    }

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
