package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.AdverseReaction;
import gov.vha.isaac.logic.LogicGraph;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class AdverseReactionClassifier extends AbstractFhirClassifier {

    private final AdverseReaction adverseReaction;

    public AdverseReactionClassifier(final TerminologyStoreDI terminologyStoreDIIn, final AdverseReaction adverseReactionIn) {
        super(terminologyStoreDIIn);
        adverseReaction = adverseReactionIn;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected LogicGraph getLogicGraph() {
        throw new UnsupportedOperationException();
    }
}
