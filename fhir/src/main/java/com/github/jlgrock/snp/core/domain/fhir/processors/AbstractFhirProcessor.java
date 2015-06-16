package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import gov.vha.isaac.logic.LogicGraph;

/**
 *
 */
public abstract class AbstractFhirProcessor implements FhirElementProcessorService {

    private final LogicGraphClassifier logicGraphClassifier;

    protected AbstractFhirProcessor(final LogicGraphClassifier logicGraphClassifierIn) {
        logicGraphClassifier = logicGraphClassifierIn;
    }

    protected LogicGraphClassifier getLogicGraphClassifier() {
        return logicGraphClassifier;
    }

    @Override
    public abstract void process();

    protected abstract LogicGraph getLogicGraph();
}
