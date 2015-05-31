package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.core.domain.fhir.model.Conformance;
import gov.vha.isaac.logic.LogicGraph;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class ConformanceProcessor extends AbstractFhirProcessor {

    private final Conformance conformance;

    public ConformanceProcessor(final TerminologyStoreDI terminologyStoreDIIn, final Conformance conformanceIn) {
        super(terminologyStoreDIIn);
        conformance = conformanceIn;
    }

    @Override
    protected LogicGraph getLogicGraph() {
        throw new UnsupportedOperationException();
    }

}
