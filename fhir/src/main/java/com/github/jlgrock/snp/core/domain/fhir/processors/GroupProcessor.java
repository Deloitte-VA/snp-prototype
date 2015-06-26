package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.Group;

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
	public void process(final String identifier) {
		throw new UnsupportedOperationException();
		
	}
}
