package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.Device;

/**
 *
 */
public class DeviceClassifier extends AbstractFhirClassifier {

    private final Device device;

    public DeviceClassifier(final Device deviceIn) {
        device = deviceIn;
    }

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
