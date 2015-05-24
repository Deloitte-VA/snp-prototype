package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.Practitioner;

/**
 *
 */
public class PractitionerClassifier extends AbstractFhirClassifier {

    private final Practitioner practitioner;

    public PractitionerClassifier(final Practitioner practitionerIn) {
        practitioner = practitionerIn;
    }

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
