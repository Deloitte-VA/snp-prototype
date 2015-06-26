package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.FamilyHistory;

/**
 *
 */
public class FamilyHistoryProcessor extends AbstractFhirProcessor {

    private final FamilyHistory familyHistory;

    public FamilyHistoryProcessor(final LogicGraphClassifier logicGraphClassifierIn, final FamilyHistory familyHistoryIn) {
        super(logicGraphClassifierIn);
        familyHistory = familyHistoryIn;
    }

	@Override
	public void process(final String identifier) {
		throw new UnsupportedOperationException();
		
	}
}
