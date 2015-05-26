package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.Profile;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class ProfileClassifier extends AbstractFhirClassifier {

    private final Profile profile;

    public ProfileClassifier(final TerminologyStoreDI terminologyStoreDIIn, final Profile profileIn) {
        super(terminologyStoreDIIn);
        profile = profileIn;
    }

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
