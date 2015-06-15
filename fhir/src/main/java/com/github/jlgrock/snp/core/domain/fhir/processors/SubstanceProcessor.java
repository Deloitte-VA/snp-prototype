package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.Substance;
import gov.vha.isaac.logic.LogicGraph;

/**
 *
 */
public class SubstanceProcessor extends AbstractFhirProcessor {

    private final Substance substance;

    public SubstanceProcessor(final LogicGraphClassifier logicGraphClassifierIn, final Substance substanceIn) {
        super(logicGraphClassifierIn);
        substance = substanceIn;
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
