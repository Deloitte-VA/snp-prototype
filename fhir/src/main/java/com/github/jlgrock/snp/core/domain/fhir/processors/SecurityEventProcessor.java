package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.core.domain.fhir.model.SecurityEvent;
import gov.vha.isaac.logic.LogicGraph;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class SecurityEventProcessor extends AbstractFhirProcessor {

    private final SecurityEvent securityEvent;

    public SecurityEventProcessor(final TerminologyStoreDI terminologyStoreDIIn, final SecurityEvent securityEventIn) {
        super(terminologyStoreDIIn);
        securityEvent = securityEventIn;
    }

    @Override
    protected LogicGraph getLogicGraph() {
        throw new UnsupportedOperationException();
    }
}
