package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.OrderResponse;
import gov.vha.isaac.logic.LogicGraph;

/**
 *
 */
public class OrderResponseProcessor extends AbstractFhirProcessor {

    private final OrderResponse orderResponse;

    public OrderResponseProcessor(final LogicGraphClassifier logicGraphClassifierIn, final OrderResponse orderResponseIn) {
        super(logicGraphClassifierIn);
        orderResponse = orderResponseIn;
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
