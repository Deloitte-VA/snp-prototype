package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.Conformance;

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
	public void process(final String identifier) {
		throw new UnsupportedOperationException();
		
	}

}
