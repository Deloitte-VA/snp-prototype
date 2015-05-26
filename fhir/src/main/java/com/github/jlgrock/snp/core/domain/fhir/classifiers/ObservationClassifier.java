package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.Observation;
import gov.vha.isaac.logic.LogicGraph;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class ObservationClassifier extends AbstractFhirClassifier {

    private final Observation observation;

    public ObservationClassifier(final TerminologyStoreDI terminologyStoreDIIn, final Observation observationIn) {
        super(terminologyStoreDIIn);
        observation = observationIn;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected LogicGraph getLogicGraph() {
        throw new UnsupportedOperationException();
    }
}
