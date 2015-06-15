package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.RelatedPerson;
import gov.vha.isaac.logic.LogicGraph;

/**
 *
 */
public class RelatedPersonProcessor extends AbstractFhirProcessor {

    private final RelatedPerson relatedPerson;

    public RelatedPersonProcessor(final LogicGraphClassifier logicGraphClassifierIn, final RelatedPerson relatedPersonIn) {
        super(logicGraphClassifierIn);
        relatedPerson = relatedPersonIn;
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
