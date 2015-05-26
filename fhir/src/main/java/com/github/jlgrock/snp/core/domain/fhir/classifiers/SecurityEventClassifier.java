package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.SecurityEvent;
import gov.vha.isaac.logic.LogicGraph;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class SecurityEventClassifier extends AbstractFhirClassifier {

    private final SecurityEvent securityEvent;

    public SecurityEventClassifier(final TerminologyStoreDI terminologyStoreDIIn, final SecurityEvent securityEventIn) {
        super(terminologyStoreDIIn);
        securityEvent = securityEventIn;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected LogicGraph getLogicGraph() {
        throw new UnsupportedOperationException();
    }
}
