package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.core.domain.fhir.model.MedicationStatement;

import gov.vha.isaac.logic.LogicGraph;

import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class MedicationStatementProcessor extends AbstractFhirProcessor {

    private final MedicationStatement medicationStatement;

    public MedicationStatementProcessor(final TerminologyStoreDI terminologyStoreDIIn, final MedicationStatement medicationStatementIn) {
        super(terminologyStoreDIIn);
        medicationStatement = medicationStatementIn;
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
