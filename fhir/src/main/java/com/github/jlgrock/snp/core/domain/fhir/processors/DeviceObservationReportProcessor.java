package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.DeviceObservationReport;
import gov.vha.isaac.logic.LogicGraph;

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
    protected LogicGraph getLogicGraph() {
        throw new UnsupportedOperationException();
    }

	@Override
	public void process() {
		throw new UnsupportedOperationException();
		
	}

}
