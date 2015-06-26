package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.Specimen;

/**
 *
 */
public class SpecimenProcessor extends AbstractFhirProcessor {

    private final Specimen specimen;

    public SpecimenProcessor(final LogicGraphClassifier logicGraphClassifierIn, final Specimen specimenIn) {
        super(logicGraphClassifierIn);
        specimen = specimenIn;
    }

	@Override
	public void process(final String identifier) {
		throw new UnsupportedOperationException();
		
	}
}
