package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.Medication;

/**
 *
 */
public class MedicationProcessor extends AbstractFhirProcessor {

    private final Medication medication;

    public MedicationProcessor(final LogicGraphClassifier logicGraphClassifierIn, final Medication medicationIn) {
        super(logicGraphClassifierIn);
        medication = medicationIn;
    }

	@Override
	public void process(final String identifier) {
		throw new UnsupportedOperationException();
		
	}
}
