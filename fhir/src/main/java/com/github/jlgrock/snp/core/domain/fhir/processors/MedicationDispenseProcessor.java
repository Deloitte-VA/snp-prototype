package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.MedicationDispense;
import gov.vha.isaac.logic.LogicGraph;

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
    protected LogicGraph getLogicGraph() {
        throw new UnsupportedOperationException();
    }

	@Override
	public void process() {
		throw new UnsupportedOperationException();
		
	}
}
