package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.AllergyIntolerance;

/**
 *
 */
public class AllergyIntoleranceProcessor extends AbstractFhirProcessor {

    private final AllergyIntolerance allergyIntolerance;

    public AllergyIntoleranceProcessor(final LogicGraphClassifier logicGraphClassifierIn, final AllergyIntolerance allergyIntoleranceIn) {
        super(logicGraphClassifierIn);
        allergyIntolerance = allergyIntoleranceIn;
    }

	@Override
	public void process(final String identifier) {
		throw new UnsupportedOperationException();
		
	}

}
