package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.Organization;

/**
 *
 */
public class OrgazationClassifier extends AbstractFhirClassifier {

    private final Organization organization;

    public OrgazationClassifier(final Organization organizationIn) {
        organization = organizationIn;
    }

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
