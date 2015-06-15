package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.Practitioner;
import gov.vha.isaac.logic.LogicGraph;

/**
 *
 */
public class PractitionerProcessor extends AbstractFhirProcessor {

    private final Practitioner practitioner;

    public PractitionerProcessor(final LogicGraphClassifier logicGraphClassifierIn, final Practitioner practitionerIn) {
        super(logicGraphClassifierIn);
        practitioner = practitionerIn;
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
