package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.core.domain.fhir.model.Organization;

import gov.vha.isaac.logic.LogicGraph;

import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class OrgazationProcessor extends AbstractFhirProcessor {

    private final Organization organization;

    public OrgazationProcessor(final TerminologyStoreDI terminologyStoreDIIn, final Organization organizationIn) {
        super(terminologyStoreDIIn);
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
