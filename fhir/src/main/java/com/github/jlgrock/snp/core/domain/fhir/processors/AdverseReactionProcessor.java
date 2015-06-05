package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.core.domain.fhir.model.AdverseReaction;
import gov.vha.isaac.logic.LogicGraph;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class AdverseReactionProcessor extends AbstractFhirProcessor {

    private final AdverseReaction adverseReaction;

    public AdverseReactionProcessor(final TerminologyStoreDI terminologyStoreDIIn, final AdverseReaction adverseReactionIn) {
        super(terminologyStoreDIIn);
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
