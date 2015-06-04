package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.core.domain.fhir.model.ImmunizationRecommendation;
import gov.vha.isaac.logic.LogicGraph;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class ImmunizationRecommendationProcessor extends AbstractFhirProcessor {

    private final ImmunizationRecommendation immunizationRecommendation;

    public ImmunizationRecommendationProcessor(final TerminologyStoreDI terminologyStoreDIIn, final ImmunizationRecommendation immunizationRecommendationIn) {
        super(terminologyStoreDIIn);
        immunizationRecommendation = immunizationRecommendationIn;
    }

    @Override
    protected LogicGraph getLogicGraph() {
        throw new UnsupportedOperationException();
    }
}
