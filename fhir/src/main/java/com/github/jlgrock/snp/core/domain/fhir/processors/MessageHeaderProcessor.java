package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.MessageHeader;
import gov.vha.isaac.logic.LogicGraph;

/**
 *
 */
public class MessageHeaderProcessor extends AbstractFhirProcessor {

    private final MessageHeader messageHeader;

    public MessageHeaderProcessor(final LogicGraphClassifier logicGraphClassifierIn, final MessageHeader messageHeaderIn) {
        super(logicGraphClassifierIn);
        messageHeader = messageHeaderIn;
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
