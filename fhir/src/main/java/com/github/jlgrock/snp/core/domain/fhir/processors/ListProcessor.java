package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.core.domain.fhir.model.List;
import gov.vha.isaac.logic.LogicGraph;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class ListProcessor extends AbstractFhirProcessor {

    private final List list;

    public ListProcessor(final TerminologyStoreDI terminologyStoreDIIn, final List listIn) {
        super(terminologyStoreDIIn);
        list = listIn;
    }

    @Override
    protected LogicGraph getLogicGraph() {
        throw new UnsupportedOperationException();
    }
}
