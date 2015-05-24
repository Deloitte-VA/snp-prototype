package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.Observation;

/**
 *
 */
public class ObservationClassifier extends AbstractFhirClassifier {

    private final Observation observation;

    public ObservationClassifier(final Observation observationIn) {
        observation = observationIn;
    }

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
