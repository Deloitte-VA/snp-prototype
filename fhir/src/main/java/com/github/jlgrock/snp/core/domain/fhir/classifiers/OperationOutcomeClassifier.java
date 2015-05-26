package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.OperationOutcome;
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

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
