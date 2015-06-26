package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.MedicationDispense;

/**
 *
 */
public class MedicationDispenseProcessor extends AbstractFhirProcessor {

    private final MedicationDispense medicationDispense;

    public MedicationDispenseProcessor(final LogicGraphClassifier logicGraphClassifierIn, final MedicationDispense medicationDispenseIn) {
        super(logicGraphClassifierIn);
        medicationDispense = medicationDispenseIn;
    }

	@Override
	public void process(final String identifier) {
		throw new UnsupportedOperationException();
		
	}
}
