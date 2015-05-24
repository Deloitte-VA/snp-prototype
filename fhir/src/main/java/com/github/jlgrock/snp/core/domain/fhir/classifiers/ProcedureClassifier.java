package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.Procedure;

/**
 *
 */
public class ProcedureClassifier extends AbstractFhirClassifier {

    private final Procedure procedure;

    public ProcedureClassifier(final Procedure procedureIn) {
        procedure = procedureIn;
    }

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
