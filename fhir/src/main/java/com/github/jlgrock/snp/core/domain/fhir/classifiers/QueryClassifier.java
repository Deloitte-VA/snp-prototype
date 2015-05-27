package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.model.Query;
import gov.vha.isaac.logic.LogicGraph;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class QueryClassifier extends AbstractFhirClassifier {

    private final Query query;

    public QueryClassifier(final TerminologyStoreDI terminologyStoreDIIn, final Query queryIn) {
        super(terminologyStoreDIIn);
        query = queryIn;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected LogicGraph getLogicGraph() {
        throw new UnsupportedOperationException();
    }
}
