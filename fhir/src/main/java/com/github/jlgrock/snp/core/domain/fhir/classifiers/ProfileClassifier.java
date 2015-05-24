package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.Profile;

/**
 *
 */
public class ProfileClassifier extends AbstractFhirClassifier {

    private final Profile profile;

    public ProfileClassifier(final Profile profileIn) {
        profile = profileIn;
    }

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
