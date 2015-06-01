package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.core.domain.fhir.model.RelatedPerson;
import gov.vha.isaac.logic.LogicGraph;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class RelatedPersonProcessor extends AbstractFhirProcessor {

    private final RelatedPerson relatedPerson;

    public RelatedPersonProcessor(final TerminologyStoreDI terminologyStoreDIIn, final RelatedPerson relatedPersonIn) {
        super(terminologyStoreDIIn);
        relatedPerson = relatedPersonIn;
    }

    @Override
    protected LogicGraph getLogicGraph() {
        throw new UnsupportedOperationException();
    }
}
