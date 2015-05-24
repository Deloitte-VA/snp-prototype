package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.Condition;

/**
 *
 */
public class ConditionClassifier extends AbstractFhirClassifier {

    private final Condition condition;

    public ConditionClassifier(final Condition conditionIn) {
        condition = conditionIn;
    }

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
