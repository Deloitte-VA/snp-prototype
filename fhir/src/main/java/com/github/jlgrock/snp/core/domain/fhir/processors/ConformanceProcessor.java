package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.Conformance;
import gov.vha.isaac.logic.LogicGraph;

/**
 *
 */
public class ConformanceProcessor extends AbstractFhirProcessor {

    private final Conformance conformance;

    public ConformanceProcessor(final LogicGraphClassifier logicGraphClassifierIn, final Conformance conformanceIn) {
        super(logicGraphClassifierIn);
        conformance = conformanceIn;
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
