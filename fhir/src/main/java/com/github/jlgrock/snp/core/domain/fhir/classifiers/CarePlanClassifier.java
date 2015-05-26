package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.CarePlan;
import gov.vha.isaac.logic.LogicGraph;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class CarePlanClassifier extends AbstractFhirClassifier {

    private final CarePlan carePlan;

    public CarePlanClassifier(final TerminologyStoreDI terminologyStoreDIIn, final CarePlan carePlanIn) {
        super(terminologyStoreDIIn);
        carePlan = carePlanIn;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected LogicGraph getLogicGraph() {
        throw new UnsupportedOperationException();
    }

}
