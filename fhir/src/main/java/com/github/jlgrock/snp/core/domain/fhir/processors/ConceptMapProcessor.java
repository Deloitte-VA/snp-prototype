package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.core.domain.fhir.model.ConceptMap;
import gov.vha.isaac.logic.LogicGraph;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class ConceptMapProcessor extends AbstractFhirProcessor {

    private final ConceptMap conceptMap;

    public ConceptMapProcessor(final TerminologyStoreDI terminologyStoreDIIn, final ConceptMap conceptMapIn) {
        super(terminologyStoreDIIn);
        conceptMap = conceptMapIn;
    }

    @Override
    protected LogicGraph getLogicGraph() {
        throw new UnsupportedOperationException();
    }

}
