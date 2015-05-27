package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.model.Order;
import gov.vha.isaac.logic.LogicGraph;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class OrderClassifier extends AbstractFhirClassifier {

    private final Order order;

    public OrderClassifier(final TerminologyStoreDI terminologyStoreDIIn, final Order orderIn) {
        super(terminologyStoreDIIn);
        order = orderIn;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected LogicGraph getLogicGraph() {
        throw new UnsupportedOperationException();
    }
}
