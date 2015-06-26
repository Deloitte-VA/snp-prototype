package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.Organization;

/**
 *
 */
public class OrgazationProcessor extends AbstractFhirProcessor {

    private final Organization organization;

    public OrgazationProcessor(final LogicGraphClassifier logicGraphClassifierIn, final Organization organizationIn) {
        super(logicGraphClassifierIn);
        organization = organizationIn;
    }

	@Override
	public void process(final String identifier) {
		throw new UnsupportedOperationException();
		
	}
}
