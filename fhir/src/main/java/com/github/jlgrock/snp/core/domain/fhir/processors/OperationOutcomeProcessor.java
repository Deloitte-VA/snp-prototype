package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.core.domain.fhir.model.OperationOutcome;
import gov.vha.isaac.logic.LogicGraph;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class OperationOutcomeProcessor extends AbstractFhirProcessor {

    private final OperationOutcome operationOutcome;

    public OperationOutcomeProcessor(final TerminologyStoreDI terminologyStoreDIIn, final OperationOutcome operationOutcomeIn) {
        super(terminologyStoreDIIn);
        operationOutcome = operationOutcomeIn;
    }

    @Override
    protected LogicGraph getLogicGraph() {
        throw new UnsupportedOperationException();
    }
}
