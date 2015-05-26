package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.Other;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class OtherClassifier extends AbstractFhirClassifier {

    private final Other other;

    public OtherClassifier(final TerminologyStoreDI terminologyStoreDIIn, final Other otherIn) {
        super(terminologyStoreDIIn);
        other = otherIn;
    }

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
