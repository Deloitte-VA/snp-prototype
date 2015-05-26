package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.Condition;
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

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
