package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.core.domain.fhir.model.ImagingStudy;

import gov.vha.isaac.logic.LogicGraph;

import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class ImagingStudyProcessor extends AbstractFhirProcessor {

    private final ImagingStudy imagingStudy;

    public ImagingStudyProcessor(final TerminologyStoreDI terminologyStoreDIIn, final ImagingStudy imagingStudyIn) {
        super(terminologyStoreDIIn);
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
