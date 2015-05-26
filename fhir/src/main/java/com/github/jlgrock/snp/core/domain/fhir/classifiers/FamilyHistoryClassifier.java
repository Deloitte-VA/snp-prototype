package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.FamilyHistory;
import gov.vha.isaac.logic.LogicGraph;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class FamilyHistoryClassifier extends AbstractFhirClassifier {

    private final FamilyHistory familyHistory;

    public FamilyHistoryClassifier(final TerminologyStoreDI terminologyStoreDIIn, final FamilyHistory familyHistoryIn) {
        super(terminologyStoreDIIn);
        familyHistory = familyHistoryIn;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected LogicGraph getLogicGraph() {
        throw new UnsupportedOperationException();
    }
}
