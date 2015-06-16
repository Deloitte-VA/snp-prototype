package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.MedicationAdministration;
import gov.vha.isaac.logic.LogicGraph;

/**
 *
 */
public class MedicationAdministractionProcessor extends AbstractFhirProcessor {

    private final MedicationAdministration medicationAdministration;

    public MedicationAdministractionProcessor(final LogicGraphClassifier logicGraphClassifierIn, final MedicationAdministration medicationAdministrationIn) {
        super(logicGraphClassifierIn);
        medicationAdministration = medicationAdministrationIn;
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
