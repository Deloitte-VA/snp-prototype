package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.Order;
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

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
