package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.ConceptMap;
import gov.vha.isaac.logic.LogicGraph;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class ConceptMapClassifier extends AbstractFhirClassifier {

    private final ConceptMap conceptMap;

    public ConceptMapClassifier(final TerminologyStoreDI terminologyStoreDIIn, final ConceptMap conceptMapIn) {
        super(terminologyStoreDIIn);
        conceptMap = conceptMapIn;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected LogicGraph getLogicGraph() {
        throw new UnsupportedOperationException();
    }

}
