package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.Location;

/**
 *
 */
public class LocationClassifier extends AbstractFhirClassifier {

    private final Location location;

    public LocationClassifier(final Location locationIn) {
        location = locationIn;
    }

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
