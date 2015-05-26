package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.Specimen;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class SpecimenClassifier extends AbstractFhirClassifier {

    private final Specimen specimen;

    public SpecimenClassifier(final TerminologyStoreDI terminologyStoreDIIn, final Specimen specimenIn) {
        super(terminologyStoreDIIn);
        specimen = specimenIn;
    }

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
