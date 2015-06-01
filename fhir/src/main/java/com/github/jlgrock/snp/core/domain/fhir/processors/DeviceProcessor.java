package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.core.domain.fhir.model.Device;
import gov.vha.isaac.logic.LogicGraph;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class DeviceProcessor extends AbstractFhirProcessor {

    private final Device device;

    public DeviceProcessor(final TerminologyStoreDI terminologyStoreDIIn, final Device deviceIn) {
        super(terminologyStoreDIIn);
        device = deviceIn;
    }

    @Override
    protected LogicGraph getLogicGraph() {
        throw new UnsupportedOperationException();
    }

}
