package com.github.jlgrock.snp.core.domain.fhir.processors;

import gov.vha.isaac.logic.LogicGraph;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public abstract class AbstractFhirProcessor implements FhirElementProcessorService {

    final private TerminologyStoreDI terminologyStoreDI;

    protected AbstractFhirProcessor(final TerminologyStoreDI terminologyStoreDIIn) {
        terminologyStoreDI = terminologyStoreDIIn;
    }

    public TerminologyStoreDI getTerminologyStoreDI() {
        return terminologyStoreDI;
    }

    @Override
    public abstract void process();

    protected abstract LogicGraph getLogicGraph();
}
