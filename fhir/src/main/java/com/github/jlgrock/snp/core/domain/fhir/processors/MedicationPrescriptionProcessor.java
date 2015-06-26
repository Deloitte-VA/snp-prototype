package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.MedicationPrescription;

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
	public void process(final String identifier) {
		throw new UnsupportedOperationException();
		
	}
}
