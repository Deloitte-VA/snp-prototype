package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.Media;
import gov.vha.isaac.logic.LogicGraph;

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
    protected LogicGraph getLogicGraph() {
        throw new UnsupportedOperationException();
    }

	@Override
	public void process() {
		throw new UnsupportedOperationException();
		
	}
}
