package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.RelatedPerson;

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
	public void process(final String identifier) {
		throw new UnsupportedOperationException();
		
	}
}
