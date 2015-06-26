package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.MessageHeader;

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
	public void process(final String identifier) {
		throw new UnsupportedOperationException();
		
	}
}
