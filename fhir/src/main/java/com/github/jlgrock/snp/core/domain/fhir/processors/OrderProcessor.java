package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.core.domain.fhir.model.Order;
import gov.vha.isaac.logic.LogicGraph;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class OrderProcessor extends AbstractFhirProcessor {

    private final Order order;

    public OrderProcessor(final TerminologyStoreDI terminologyStoreDIIn, final Order orderIn) {
        super(terminologyStoreDIIn);
        order = orderIn;
    }

    @Override
    protected LogicGraph getLogicGraph() {
        throw new UnsupportedOperationException();
    }
}
