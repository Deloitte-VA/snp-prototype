package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.SecurityEvent;

/**
 *
 */
public class SecurityEventProcessor extends AbstractFhirProcessor {

    private final SecurityEvent securityEvent;

    public SecurityEventProcessor(final LogicGraphClassifier logicGraphClassifierIn, final SecurityEvent securityEventIn) {
        super(logicGraphClassifierIn);
        securityEvent = securityEventIn;
    }

	@Override
	public void process(final String identifier) {
		throw new UnsupportedOperationException();
		
	}
}
