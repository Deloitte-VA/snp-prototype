package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.core.domain.fhir.model.Condition;
import gov.vha.isaac.logic.LogicGraph;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class ConditionProcessor extends AbstractFhirProcessor {

    private final Condition condition;

    public ConditionProcessor(final TerminologyStoreDI terminologyStoreDIIn, final Condition conditionIn) {
        super(terminologyStoreDIIn);
        condition = conditionIn;
    }

    @Override
    protected LogicGraph getLogicGraph() {
        throw new UnsupportedOperationException();
    }

}
