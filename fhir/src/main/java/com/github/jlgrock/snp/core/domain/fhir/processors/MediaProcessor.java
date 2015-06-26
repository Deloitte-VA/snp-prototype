package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.Media;

/**
 *
 */
public class MediaProcessor extends AbstractFhirProcessor {

    private final Media media;

    public MediaProcessor(final LogicGraphClassifier logicGraphClassifierIn, final Media mediaIn) {
        super(logicGraphClassifierIn);
        media = mediaIn;
    }

	@Override
	public void process(final String identifier) {
		throw new UnsupportedOperationException();
		
	}
}
