package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.Immunization;

/**
 *
 */
public class ImmunizationClassifier extends AbstractFhirClassifier {

    private final Immunization immunization;

    public ImmunizationClassifier(final Immunization immunizationIn) {
        immunization = immunizationIn;
    }

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
