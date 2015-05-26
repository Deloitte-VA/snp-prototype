package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.RelatedPerson;
import gov.vha.isaac.logic.LogicGraph;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class RelatedPersonClassifier extends AbstractFhirClassifier {

    private final RelatedPerson relatedPerson;

    public RelatedPersonClassifier(final TerminologyStoreDI terminologyStoreDIIn, final RelatedPerson relatedPersonIn) {
        super(terminologyStoreDIIn);
        relatedPerson = relatedPersonIn;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected LogicGraph getLogicGraph() {
        throw new UnsupportedOperationException();
    }
}
