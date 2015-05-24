package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.Specimen;

/**
 *
 */
public class SpecimenClassifier extends AbstractFhirClassifier {

    private final Specimen specimen;

    public SpecimenClassifier(final Specimen specimenIn) {
        specimen = specimenIn;
    }

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
