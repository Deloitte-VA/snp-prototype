package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.core.domain.fhir.model.Group;
import gov.vha.isaac.logic.LogicGraph;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class GroupProcessor extends AbstractFhirProcessor {

    private final Group group;

    public GroupProcessor(final TerminologyStoreDI terminologyStoreDIIn, final Group groupIn) {
        super(terminologyStoreDIIn);
        group = groupIn;
    }

    @Override
    protected LogicGraph getLogicGraph() {
        throw new UnsupportedOperationException();
    }
}
