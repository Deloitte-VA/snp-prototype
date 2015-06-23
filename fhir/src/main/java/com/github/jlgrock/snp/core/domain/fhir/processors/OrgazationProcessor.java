package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.Organization;
import gov.vha.isaac.logic.LogicGraph;

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
    protected LogicGraph getLogicGraph() {
        throw new UnsupportedOperationException();
    }

	@Override
	public void process() {
		throw new UnsupportedOperationException();
		
	}
}
