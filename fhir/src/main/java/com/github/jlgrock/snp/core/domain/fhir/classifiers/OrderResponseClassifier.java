package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.OrderResponse;
import gov.vha.isaac.logic.LogicGraph;
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

    /**
     * {@inheritDoc}
     */
    @Override
    protected LogicGraph getLogicGraph() {
        throw new UnsupportedOperationException();
    }
}
