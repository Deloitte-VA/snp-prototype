package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.MedicationPrescription;
import gov.vha.isaac.logic.LogicGraph;

/**
 *
 */
public class MedicationPrescriptionProcessor extends AbstractFhirProcessor {

    private final MedicationPrescription medicationPrescription;

    public MedicationPrescriptionProcessor(final LogicGraphClassifier logicGraphClassifierIn, final MedicationPrescription medicationPrescriptionIn) {
        super(logicGraphClassifierIn);
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
