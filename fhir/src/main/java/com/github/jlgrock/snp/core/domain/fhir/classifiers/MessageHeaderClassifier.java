package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.MessageHeader;
import gov.vha.isaac.logic.LogicGraph;
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

    /**
     * {@inheritDoc}
     */
    @Override
    protected LogicGraph getLogicGraph() {
        throw new UnsupportedOperationException();
    }
}
