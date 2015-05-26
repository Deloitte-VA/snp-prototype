package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.DeviceObservationReport;
import gov.vha.isaac.logic.LogicGraph;
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

    /**
     * {@inheritDoc}
     */
    @Override
    protected LogicGraph getLogicGraph() {
        throw new UnsupportedOperationException();
    }

}
