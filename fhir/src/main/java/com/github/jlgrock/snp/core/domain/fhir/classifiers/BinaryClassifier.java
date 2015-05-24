package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.Binary;

/**
 *
 */
public class BinaryClassifier extends AbstractFhirClassifier {

    private final Binary binary;

    public BinaryClassifier(final Binary binaryIn) {
        binary = binaryIn;
    }

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
