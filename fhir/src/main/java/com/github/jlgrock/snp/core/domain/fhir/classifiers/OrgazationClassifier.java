package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.Organization;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class OrgazationClassifier extends AbstractFhirClassifier {

    private final Organization organization;

    public OrgazationClassifier(final TerminologyStoreDI terminologyStoreDIIn, final Organization organizationIn) {
        super(terminologyStoreDIIn);
        organization = organizationIn;
    }

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
