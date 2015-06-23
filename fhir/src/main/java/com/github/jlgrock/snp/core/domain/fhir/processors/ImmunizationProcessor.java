package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.Immunization;
import gov.vha.isaac.logic.LogicGraph;

/**
 *
 */
public class ImmunizationProcessor extends AbstractFhirProcessor {

    private final Immunization immunization;

    public ImmunizationProcessor(final LogicGraphClassifier logicGraphClassifierIn, final Immunization immunizationIn) {
        super(logicGraphClassifierIn);
        immunization = immunizationIn;
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
