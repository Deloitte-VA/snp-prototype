package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.Media;

/**
 *
 */
public class MediaClassifier extends AbstractFhirClassifier {

    private final Media media;

    public MediaClassifier(final Media mediaIn) {
        media = mediaIn;
    }

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
