package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.List;
import gov.vha.isaac.logic.LogicGraph;

/**
 *
 */
public class ListProcessor extends AbstractFhirProcessor {

    private final List list;

    public ListProcessor(final LogicGraphClassifier logicGraphClassifierIn, final List listIn) {
        super(logicGraphClassifierIn);
        list = listIn;
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
