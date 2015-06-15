package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.Medication;
import gov.vha.isaac.logic.LogicGraph;

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
    protected LogicGraph getLogicGraph() {
        throw new UnsupportedOperationException();
    }

	@Override
	public void process() {
		throw new UnsupportedOperationException();
		
	}
}
