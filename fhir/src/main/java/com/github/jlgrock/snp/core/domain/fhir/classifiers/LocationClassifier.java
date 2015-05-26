package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.Location;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class LocationClassifier extends AbstractFhirClassifier {

    private final Location location;

    public LocationClassifier(final TerminologyStoreDI terminologyStoreDIIn, final Location locationIn) {
        super(terminologyStoreDIIn);
        location = locationIn;
    }

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
