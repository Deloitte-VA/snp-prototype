package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.ImagingStudy;
import gov.vha.isaac.logic.LogicGraph;

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
    protected LogicGraph getLogicGraph() {
        throw new UnsupportedOperationException();
    }

	@Override
	public void process() {
		throw new UnsupportedOperationException();
		
	}
}
