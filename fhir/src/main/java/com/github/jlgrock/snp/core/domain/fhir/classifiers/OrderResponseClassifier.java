package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.OrderResponse;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class OrderResponseClassifier extends AbstractFhirClassifier {

    private final OrderResponse orderResponse;

    public OrderResponseClassifier(final TerminologyStoreDI terminologyStoreDIIn, final OrderResponse orderResponseIn) {
        super(terminologyStoreDIIn);
        orderResponse = orderResponseIn;
    }

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
