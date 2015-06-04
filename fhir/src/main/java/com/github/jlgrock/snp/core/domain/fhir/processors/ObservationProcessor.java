package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.core.domain.fhir.model.Observation;
import gov.vha.isaac.logic.LogicGraph;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class ObservationProcessor extends AbstractFhirProcessor {

    private final Observation observation;

    public ObservationProcessor(final TerminologyStoreDI terminologyStoreDIIn, final Observation observationIn) {
        super(terminologyStoreDIIn);
        observation = observationIn;
    }

    @Override
    protected LogicGraph getLogicGraph() {
        throw new UnsupportedOperationException();
    }
}
