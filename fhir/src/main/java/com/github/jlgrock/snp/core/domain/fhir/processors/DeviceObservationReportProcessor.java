package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicalExpressionClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.DeviceObservationReport;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;

/**
 * The processor used for handling DeviceObservation objects unmarshalled from FHIR XML.
 */
@Service
public class DeviceObservationReportProcessor extends AbstractFhirProcessor {

    /**
     * Constructor.
     * @param logicalExpressionClassifierIn the classification utility for when a logical encounter is created
     */
    @Inject
    public DeviceObservationReportProcessor(final LogicalExpressionClassifier logicalExpressionClassifierIn) {
        super(logicalExpressionClassifierIn);
    }

	@Override
	public void process(final String identifier, final Object unmarshalledObject) {
        DeviceObservationReport deviceObservationReport = (DeviceObservationReport) unmarshalledObject;
		throw new UnsupportedOperationException();
	}

    @Override
    public Class processesType() {
        return DeviceObservationReport.class;
    }

}
