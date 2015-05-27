package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.model.List;
import gov.vha.isaac.logic.LogicGraph;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class ListClassifier extends AbstractFhirClassifier {

    private final List list;

    public ListClassifier(final TerminologyStoreDI terminologyStoreDIIn, final List listIn) {
        super(terminologyStoreDIIn);
        list = listIn;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected LogicGraph getLogicGraph() {
        throw new UnsupportedOperationException();
    }
}
