package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.Group;
import gov.vha.isaac.logic.LogicGraph;

/**
 *
 */
public class GroupProcessor extends AbstractFhirProcessor {

    private final Group group;

    public GroupProcessor(final LogicGraphClassifier logicGraphClassifierIn, final Group groupIn) {
        super(logicGraphClassifierIn);
        group = groupIn;
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
