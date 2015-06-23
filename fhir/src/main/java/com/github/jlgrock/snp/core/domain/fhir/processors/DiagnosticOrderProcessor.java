package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.DiagnosticOrder;
import gov.vha.isaac.logic.LogicGraph;

/**
 *
 */
public class DiagnosticOrderProcessor extends AbstractFhirProcessor {

    private final DiagnosticOrder diagnosticOrder;

    public DiagnosticOrderProcessor(final LogicGraphClassifier logicGraphClassifierIn, final DiagnosticOrder diagnosticOrderIn) {
        super(logicGraphClassifierIn);
        diagnosticOrder = diagnosticOrderIn;
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
