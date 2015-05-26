package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.Device;
import gov.vha.isaac.logic.LogicGraph;
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

    /**
     * {@inheritDoc}
     */
    @Override
    protected LogicGraph getLogicGraph() {
        throw new UnsupportedOperationException();
    }

}
