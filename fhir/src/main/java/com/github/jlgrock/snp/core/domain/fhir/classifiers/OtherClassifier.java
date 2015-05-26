package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.Other;
import gov.vha.isaac.logic.LogicGraph;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class OtherClassifier extends AbstractFhirClassifier {

    private final Other other;

    public OtherClassifier(final TerminologyStoreDI terminologyStoreDIIn, final Other otherIn) {
        super(terminologyStoreDIIn);
        other = otherIn;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected LogicGraph getLogicGraph() {
        throw new UnsupportedOperationException();
    }
}
