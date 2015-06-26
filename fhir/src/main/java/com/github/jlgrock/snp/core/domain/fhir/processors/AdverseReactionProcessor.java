package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.AdverseReaction;

/**
 *
 */
public class AdverseReactionProcessor extends AbstractFhirProcessor {

    private final AdverseReaction adverseReaction;

    public AdverseReactionProcessor(final LogicGraphClassifier logicGraphClassifierIn, final AdverseReaction adverseReactionIn) {
        super(logicGraphClassifierIn);
        adverseReaction = adverseReactionIn;
    }

	@Override
	public void process(final String identifier) {
		throw new UnsupportedOperationException();
		
	}
}
