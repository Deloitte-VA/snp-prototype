package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.Order;
import gov.vha.isaac.logic.LogicGraph;

/**
 *
 */
public class OrderProcessor extends AbstractFhirProcessor {

    private final Order order;

    public OrderProcessor(final LogicGraphClassifier logicGraphClassifierIn, final Order orderIn) {
        super(logicGraphClassifierIn);
        order = orderIn;
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
