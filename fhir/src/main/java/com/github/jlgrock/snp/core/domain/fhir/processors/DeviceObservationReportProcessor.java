package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.DeviceObservationReport;

/**
 *
 */
public class DeviceObservationReportProcessor extends AbstractFhirProcessor {

    private final DeviceObservationReport deviceObservationReport;

    public DeviceObservationReportProcessor(final LogicGraphClassifier logicGraphClassifierIn, final DeviceObservationReport deviceObservationReportIn) {
        super(logicGraphClassifierIn);
        deviceObservationReport = deviceObservationReportIn;
    }

	@Override
	public void process(final String identifier) {
		throw new UnsupportedOperationException();
		
	}

}
