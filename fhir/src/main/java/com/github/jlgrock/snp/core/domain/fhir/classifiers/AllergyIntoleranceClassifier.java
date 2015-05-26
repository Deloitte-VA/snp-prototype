package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.AllergyIntolerance;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class AllergyIntoleranceClassifier extends AbstractFhirClassifier {

    private final AllergyIntolerance allergyIntolerance;

    public AllergyIntoleranceClassifier(final TerminologyStoreDI terminologyStoreDIIn, final AllergyIntolerance allergyIntoleranceIn) {
        super(terminologyStoreDIIn);
        allergyIntolerance = allergyIntoleranceIn;
    }

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
