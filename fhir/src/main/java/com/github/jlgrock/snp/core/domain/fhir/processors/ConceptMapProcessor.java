package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.ConceptMap;
import gov.vha.isaac.logic.LogicGraph;

/**
 *
 */
public class ConceptMapProcessor extends AbstractFhirProcessor {

    private final ConceptMap conceptMap;

    public ConceptMapProcessor(final LogicGraphClassifier logicGraphClassifierIn, final ConceptMap conceptMapIn) {
        super(logicGraphClassifierIn);
        conceptMap = conceptMapIn;
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
