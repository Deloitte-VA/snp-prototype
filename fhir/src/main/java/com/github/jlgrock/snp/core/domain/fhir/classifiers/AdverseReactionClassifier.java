package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.AdverseReaction;

/**
 *
 */
public class AdverseReactionClassifier extends AbstractFhirClassifier {

    private final AdverseReaction adverseReaction;

    public AdverseReactionClassifier(final AdverseReaction adverseReactionIn) {
        adverseReaction = adverseReactionIn;
    }

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
