package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.Profile;

/**
 *
 */
public class ProfileProcessor extends AbstractFhirProcessor {

    private final Profile profile;

    public ProfileProcessor(final LogicGraphClassifier logicGraphClassifierIn, final Profile profileIn) {
        super(logicGraphClassifierIn);
        profile = profileIn;
    }

	@Override
	public void process(final String identifier) {
		throw new UnsupportedOperationException();
		
	}
}
