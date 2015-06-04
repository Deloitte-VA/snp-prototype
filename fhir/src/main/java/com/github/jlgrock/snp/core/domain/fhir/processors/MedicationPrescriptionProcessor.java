package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.core.domain.fhir.model.MedicationPrescription;

import gov.vha.isaac.logic.LogicGraph;

import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class MedicationPrescriptionProcessor extends AbstractFhirProcessor {

    private final MedicationPrescription medicationPrescription;

    public MedicationPrescriptionProcessor(final TerminologyStoreDI terminologyStoreDIIn, final MedicationPrescription medicationPrescriptionIn) {
        super(terminologyStoreDIIn);
        medicationPrescription = medicationPrescriptionIn;
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
