package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.MessageHeader;

/**
 *
 */
public class MessageHeaderClassifier extends AbstractFhirClassifier {

    private final MessageHeader messageHeader;

    public MessageHeaderClassifier(final MessageHeader messageHeaderIn) {
        messageHeader = messageHeaderIn;
    }

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
