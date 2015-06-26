package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.OrderResponse;

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
	public void process(final String identifier) {
		throw new UnsupportedOperationException();
		
	}
}
