package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.MessageHeader;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class MessageHeaderClassifier extends AbstractFhirClassifier {

    private final MessageHeader messageHeader;

    public MessageHeaderClassifier(final TerminologyStoreDI terminologyStoreDIIn, final MessageHeader messageHeaderIn) {
        super(terminologyStoreDIIn);
        messageHeader = messageHeaderIn;
    }

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
