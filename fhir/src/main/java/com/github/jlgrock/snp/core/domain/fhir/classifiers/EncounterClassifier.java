package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.Encounter;

/**
 *
 */
public class EncounterClassifier extends AbstractFhirClassifier {

    private final Encounter encounter;

    public EncounterClassifier(final Encounter encounterIn) {
        encounter = encounterIn;
    }

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
