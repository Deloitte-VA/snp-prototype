package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.AdverseReaction;
import gov.vha.isaac.logic.LogicGraph;

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
    protected LogicGraph getLogicGraph() {
        throw new UnsupportedOperationException();
    }

	@Override
	public void process() {
		throw new UnsupportedOperationException();
		
	}
}
