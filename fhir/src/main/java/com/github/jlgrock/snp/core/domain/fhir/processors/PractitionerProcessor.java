package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.Practitioner;

/**
 *
 */
public class PractitionerProcessor extends AbstractFhirProcessor {

    private final Practitioner practitioner;

    public PractitionerProcessor(final LogicGraphClassifier logicGraphClassifierIn, final Practitioner practitionerIn) {
        super(logicGraphClassifierIn);
        practitioner = practitionerIn;
    }

	@Override
	public void process(final String identifier) {
		throw new UnsupportedOperationException();
		
	}
}
