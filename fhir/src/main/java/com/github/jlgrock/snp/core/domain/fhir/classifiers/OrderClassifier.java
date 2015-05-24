package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.Order;

/**
 *
 */
public class OrderClassifier extends AbstractFhirClassifier {

    private final Order order;

    public OrderClassifier(final Order orderIn) {
        order = orderIn;
    }

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
