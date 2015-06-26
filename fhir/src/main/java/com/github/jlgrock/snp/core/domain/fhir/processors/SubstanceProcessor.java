package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.Substance;

/**
 *
 */
public class SubstanceProcessor extends AbstractFhirProcessor {

    private final Substance substance;

    public SubstanceProcessor(final LogicGraphClassifier logicGraphClassifierIn, final Substance substanceIn) {
        super(logicGraphClassifierIn);
        substance = substanceIn;
    }

	@Override
	public void process(final String identifier) {
		throw new UnsupportedOperationException();
		
	}
}
