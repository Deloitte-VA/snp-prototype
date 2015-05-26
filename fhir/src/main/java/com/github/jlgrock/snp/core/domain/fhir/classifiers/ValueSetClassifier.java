package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.ValueSet;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class ValueSetClassifier extends AbstractFhirClassifier {

    private final ValueSet valueSet;

    public ValueSetClassifier(final TerminologyStoreDI terminologyStoreDIIn, final ValueSet valueSetIn) {
        super(terminologyStoreDIIn);
        valueSet = valueSetIn;
    }

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
