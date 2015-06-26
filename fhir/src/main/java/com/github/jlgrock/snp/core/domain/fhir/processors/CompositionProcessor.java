package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.Composition;

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
	public void process(final String identifier) {
		throw new UnsupportedOperationException();
		
	}

}
