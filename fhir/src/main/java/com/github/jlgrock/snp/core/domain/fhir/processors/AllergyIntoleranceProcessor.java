package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.core.domain.fhir.model.AllergyIntolerance;
import gov.vha.isaac.logic.LogicGraph;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class AllergyIntoleranceProcessor extends AbstractFhirProcessor {

    private final AllergyIntolerance allergyIntolerance;

    public AllergyIntoleranceProcessor(final TerminologyStoreDI terminologyStoreDIIn, final AllergyIntolerance allergyIntoleranceIn) {
        super(terminologyStoreDIIn);
        allergyIntolerance = allergyIntoleranceIn;
    }

    @Override
    protected LogicGraph getLogicGraph() {
        throw new UnsupportedOperationException();
    }

}
