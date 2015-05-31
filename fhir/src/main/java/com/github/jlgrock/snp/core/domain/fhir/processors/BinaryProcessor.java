package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.core.domain.fhir.model.Binary;
import gov.vha.isaac.logic.LogicGraph;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class BinaryProcessor extends AbstractFhirProcessor {

    private final Binary binary;

    public BinaryProcessor(final TerminologyStoreDI terminologyStoreDIIn, final Binary binaryIn) {
        super(terminologyStoreDIIn);
        binary = binaryIn;
    }

    @Override
    protected LogicGraph getLogicGraph() {
        throw new UnsupportedOperationException();
    }

}
