package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.Profile;
import gov.vha.isaac.logic.LogicGraph;

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
    protected LogicGraph getLogicGraph() {
        throw new UnsupportedOperationException();
    }

	@Override
	public void process() {
		throw new UnsupportedOperationException();
		
	}
}
