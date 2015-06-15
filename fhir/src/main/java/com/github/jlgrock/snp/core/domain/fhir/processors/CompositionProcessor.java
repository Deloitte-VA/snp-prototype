package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.Composition;
import gov.vha.isaac.logic.LogicGraph;

/**
 *
 */
public class CompositionProcessor extends AbstractFhirProcessor {

    private final Composition composition;

    public CompositionProcessor(final LogicGraphClassifier logicGraphClassifierIn, final Composition compositionIn) {
        super(logicGraphClassifierIn);
        composition = compositionIn;
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
