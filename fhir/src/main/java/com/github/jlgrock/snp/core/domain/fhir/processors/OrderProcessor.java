package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.Order;

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
	public void process(final String identifier) {
		throw new UnsupportedOperationException();
		
	}
}
