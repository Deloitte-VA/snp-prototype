package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.ConceptMap;

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
	public void process(final String identifier) {
		throw new UnsupportedOperationException();
		
	}

}
