package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.model.AllergyIntolerance;
import gov.vha.isaac.logic.LogicGraph;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class AllergyIntoleranceClassifier extends AbstractFhirClassifier {

    private final AllergyIntolerance allergyIntolerance;

    public AllergyIntoleranceClassifier(final TerminologyStoreDI terminologyStoreDIIn, final AllergyIntolerance allergyIntoleranceIn) {
        super(terminologyStoreDIIn);
        allergyIntolerance = allergyIntoleranceIn;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected LogicGraph getLogicGraph() {
        throw new UnsupportedOperationException();
    }

}
