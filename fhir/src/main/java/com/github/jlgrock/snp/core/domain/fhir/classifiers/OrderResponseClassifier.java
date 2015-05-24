package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.OrderResponse;

/**
 *
 */
public class OrderResponseClassifier extends AbstractFhirClassifier {

    private final OrderResponse orderResponse;

    public OrderResponseClassifier(final OrderResponse orderResponseIn) {
        orderResponse = orderResponseIn;
    }

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
