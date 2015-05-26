package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.DeviceObservationReport;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class DeviceObservationReportClassifier extends AbstractFhirClassifier {

    private final DeviceObservationReport deviceObservationReport;

    public DeviceObservationReportClassifier(final TerminologyStoreDI terminologyStoreDIIn, final DeviceObservationReport deviceObservationReportIn) {
        super(terminologyStoreDIIn);
        deviceObservationReport = deviceObservationReportIn;
    }

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
