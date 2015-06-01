package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.core.domain.fhir.model.MessageHeader;
import gov.vha.isaac.logic.LogicGraph;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class MessageHeaderProcessor extends AbstractFhirProcessor {

    private final MessageHeader messageHeader;

    public MessageHeaderProcessor(final TerminologyStoreDI terminologyStoreDIIn, final MessageHeader messageHeaderIn) {
        super(terminologyStoreDIIn);
        messageHeader = messageHeaderIn;
    }

    @Override
    protected LogicGraph getLogicGraph() {
        throw new UnsupportedOperationException();
    }
}
