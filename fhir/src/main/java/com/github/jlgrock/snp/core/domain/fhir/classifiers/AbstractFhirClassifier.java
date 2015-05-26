package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import gov.vha.isaac.logic.LogicGraph;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public abstract class AbstractFhirClassifier implements FhirElementClassifierService {

    final private TerminologyStoreDI terminologyStoreDI;

    protected AbstractFhirClassifier(final TerminologyStoreDI terminologyStoreDIIn) {
        terminologyStoreDI = terminologyStoreDIIn;
    }

    public TerminologyStoreDI getTerminologyStoreDI() {
        return terminologyStoreDI;
    }

    @Override
    public void classify() {
        LogicGraph logicGraphBuilder = getLogicGraph();

        //TODO run through classification service, should get a number back.

        //TODO store concept ID, and logic graph expression

    }

    protected abstract LogicGraph getLogicGraph();
}
