package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.ImagingStudy;

/**
 *
 */
public class ImagingStudyProcessor extends AbstractFhirProcessor {

    private final ImagingStudy imagingStudy;

    public ImagingStudyProcessor(final LogicGraphClassifier logicGraphClassifierIn, final ImagingStudy imagingStudyIn) {
        super(logicGraphClassifierIn);
        imagingStudy = imagingStudyIn;
    }

	@Override
	public void process(final String identifier) {
		throw new UnsupportedOperationException();
		
	}
}
