package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.Substance;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class SubstanceClassifier extends AbstractFhirClassifier {

    private final Substance substance;

    public SubstanceClassifier(final TerminologyStoreDI terminologyStoreDIIn, final Substance substanceIn) {
        super(terminologyStoreDIIn);
        substance = substanceIn;
    }

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
