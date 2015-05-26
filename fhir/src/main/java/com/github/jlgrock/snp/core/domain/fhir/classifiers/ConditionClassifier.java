package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.Condition;
import gov.vha.isaac.logic.LogicGraph;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class ConditionClassifier extends AbstractFhirClassifier {

    private final Condition condition;

    public ConditionClassifier(final TerminologyStoreDI terminologyStoreDIIn, final Condition conditionIn) {
        super(terminologyStoreDIIn);
        condition = conditionIn;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected LogicGraph getLogicGraph() {
        throw new UnsupportedOperationException();
    }

}
