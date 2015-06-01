package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.core.domain.fhir.model.Query;
import gov.vha.isaac.logic.LogicGraph;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class QueryProcessor extends AbstractFhirProcessor {

    private final Query query;

    public QueryProcessor(final TerminologyStoreDI terminologyStoreDIIn, final Query queryIn) {
        super(terminologyStoreDIIn);
        query = queryIn;
    }

    @Override
    protected LogicGraph getLogicGraph() {
        throw new UnsupportedOperationException();
    }
}
