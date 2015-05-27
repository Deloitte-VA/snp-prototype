package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.model.OperationOutcome;
import gov.vha.isaac.logic.LogicGraph;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class OperationOutcomeClassifier extends AbstractFhirClassifier {

    private final OperationOutcome operationOutcome;

    public OperationOutcomeClassifier(final TerminologyStoreDI terminologyStoreDIIn, final OperationOutcome operationOutcomeIn) {
        super(terminologyStoreDIIn);
        operationOutcome = operationOutcomeIn;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected LogicGraph getLogicGraph() {
        throw new UnsupportedOperationException();
    }
}
