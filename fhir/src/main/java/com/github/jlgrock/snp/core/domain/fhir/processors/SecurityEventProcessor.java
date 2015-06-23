package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.SecurityEvent;
import gov.vha.isaac.logic.LogicGraph;

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
    protected LogicGraph getLogicGraph() {
        throw new UnsupportedOperationException();
    }

	@Override
	public void process() {
		throw new UnsupportedOperationException();
		
	}
}
