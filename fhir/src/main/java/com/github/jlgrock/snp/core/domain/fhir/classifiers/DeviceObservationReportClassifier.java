package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.DeviceObservationReport;

/**
 *
 */
public class DeviceObservationReportClassifier extends AbstractFhirClassifier {

    private final DeviceObservationReport deviceObservationReport;

    public DeviceObservationReportClassifier(final DeviceObservationReport deviceObservationReportIn) {
        deviceObservationReport = deviceObservationReportIn;
    }

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
