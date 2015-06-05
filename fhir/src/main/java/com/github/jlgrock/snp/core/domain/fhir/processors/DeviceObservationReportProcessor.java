package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.core.domain.fhir.model.DeviceObservationReport;

import gov.vha.isaac.logic.LogicGraph;

import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class DeviceObservationReportProcessor extends AbstractFhirProcessor {

    private final DeviceObservationReport deviceObservationReport;

    public DeviceObservationReportProcessor(final TerminologyStoreDI terminologyStoreDIIn, final DeviceObservationReport deviceObservationReportIn) {
        super(terminologyStoreDIIn);
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
