package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.AdverseReaction;
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

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
