package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.MedicationStatement;
import gov.vha.isaac.logic.LogicGraph;

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
    protected LogicGraph getLogicGraph() {
        throw new UnsupportedOperationException();
    }

	@Override
	public void process() {
		throw new UnsupportedOperationException();
		
	}
}
