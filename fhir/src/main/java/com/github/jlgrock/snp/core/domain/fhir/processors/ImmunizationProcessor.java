package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.Immunization;

/**
 *
 */
public class ImmunizationProcessor extends AbstractFhirProcessor {

    private final Immunization immunization;

    public ImmunizationProcessor(final LogicGraphClassifier logicGraphClassifierIn, final Immunization immunizationIn) {
        super(logicGraphClassifierIn);
        immunization = immunizationIn;
    }

	@Override
	public void process(final String identifier) {
		throw new UnsupportedOperationException();
		
	}
}
