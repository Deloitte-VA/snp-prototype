package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.core.domain.fhir.model.Medication;

import gov.vha.isaac.logic.LogicGraph;

import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class MedicationProcessor extends AbstractFhirProcessor {

    private final Medication medication;

    public MedicationProcessor(final TerminologyStoreDI terminologyStoreDIIn, final Medication medicationIn) {
        super(terminologyStoreDIIn);
        medication = medicationIn;
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
