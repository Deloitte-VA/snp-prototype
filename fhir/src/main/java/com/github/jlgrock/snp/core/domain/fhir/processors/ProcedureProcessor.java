package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.Procedure;
import gov.vha.isaac.logic.LogicGraph;

/**
 *
 */
public class ProcedureProcessor extends AbstractFhirProcessor {

    private final Procedure procedure;

    public ProcedureProcessor(final LogicGraphClassifier logicGraphClassifierIn, final Procedure procedureIn) {
        super(logicGraphClassifierIn);
        procedure = procedureIn;
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
