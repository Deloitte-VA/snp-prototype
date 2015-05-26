package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.Device;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class DeviceClassifier extends AbstractFhirClassifier {

    private final Device device;

    public DeviceClassifier(final TerminologyStoreDI terminologyStoreDIIn, final Device deviceIn) {
        super(terminologyStoreDIIn);
        device = deviceIn;
    }

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
