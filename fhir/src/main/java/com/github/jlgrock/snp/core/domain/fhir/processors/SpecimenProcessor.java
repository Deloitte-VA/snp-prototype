package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.Specimen;
import gov.vha.isaac.logic.LogicGraph;

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
    protected LogicGraph getLogicGraph() {
        throw new UnsupportedOperationException();
    }

	@Override
	public void process() {
		throw new UnsupportedOperationException();
		
	}
}
