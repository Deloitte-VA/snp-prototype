package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.Practitioner;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class PractitionerClassifier extends AbstractFhirClassifier {

    private final Practitioner practitioner;

    public PractitionerClassifier(final TerminologyStoreDI terminologyStoreDIIn, final Practitioner practitionerIn) {
        super(terminologyStoreDIIn);
        practitioner = practitionerIn;
    }

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
