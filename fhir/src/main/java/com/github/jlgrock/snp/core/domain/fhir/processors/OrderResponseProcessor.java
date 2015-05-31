package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.core.domain.fhir.model.OrderResponse;
import gov.vha.isaac.logic.LogicGraph;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class OrderResponseProcessor extends AbstractFhirProcessor {

    private final OrderResponse orderResponse;

    public OrderResponseProcessor(final TerminologyStoreDI terminologyStoreDIIn, final OrderResponse orderResponseIn) {
        super(terminologyStoreDIIn);
        orderResponse = orderResponseIn;
    }

    @Override
    protected LogicGraph getLogicGraph() {
        throw new UnsupportedOperationException();
    }
}
