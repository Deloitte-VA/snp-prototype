package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.FamilyHistory;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class FamilyHistoryClassifier extends AbstractFhirClassifier {

    private final FamilyHistory familyHistory;

    public FamilyHistoryClassifier(final TerminologyStoreDI terminologyStoreDIIn, final FamilyHistory familyHistoryIn) {
        super(terminologyStoreDIIn);
        familyHistory = familyHistoryIn;
    }

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
