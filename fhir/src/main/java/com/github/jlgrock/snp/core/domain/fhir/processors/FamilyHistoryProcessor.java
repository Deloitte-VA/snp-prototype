package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.core.domain.fhir.model.FamilyHistory;
import gov.vha.isaac.logic.LogicGraph;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class FamilyHistoryProcessor extends AbstractFhirProcessor {

    private final FamilyHistory familyHistory;

    public FamilyHistoryProcessor(final TerminologyStoreDI terminologyStoreDIIn, final FamilyHistory familyHistoryIn) {
        super(terminologyStoreDIIn);
        familyHistory = familyHistoryIn;
    }

    @Override
    protected LogicGraph getLogicGraph() {
        throw new UnsupportedOperationException();
    }
}
