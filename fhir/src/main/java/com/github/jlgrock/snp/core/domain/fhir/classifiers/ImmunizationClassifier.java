package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.Immunization;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class ImmunizationClassifier extends AbstractFhirClassifier {

    private final Immunization immunization;

    public ImmunizationClassifier(final TerminologyStoreDI terminologyStoreDIIn, final Immunization immunizationIn) {
        super(terminologyStoreDIIn);
        immunization = immunizationIn;
    }

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
