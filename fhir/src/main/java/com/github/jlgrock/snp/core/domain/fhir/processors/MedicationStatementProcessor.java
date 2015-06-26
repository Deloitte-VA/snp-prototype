package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.MedicationStatement;

/**
 *
 */
public class MedicationStatementProcessor extends AbstractFhirProcessor {

    private final MedicationStatement medicationStatement;

    public MedicationStatementProcessor(final LogicGraphClassifier logicGraphClassifierIn, final MedicationStatement medicationStatementIn) {
        super(logicGraphClassifierIn);
        medicationStatement = medicationStatementIn;
    }

	@Override
	public void process(final String identifier) {
		throw new UnsupportedOperationException();
		
	}
}
