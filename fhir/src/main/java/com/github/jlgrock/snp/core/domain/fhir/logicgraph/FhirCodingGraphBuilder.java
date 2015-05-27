package com.github.jlgrock.snp.core.domain.fhir.logicgraph;

import com.github.jlgrock.snp.core.domain.fhir.model.Coding;
import gov.vha.isaac.logic.node.AbstractNode;
import gov.vha.isaac.logic.node.RootNode;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 */
public class FhirCodingGraphBuilder extends AbstractFhirLogicGraphBuilder {
    private static final Logger LOGGER = LoggerFactory.getLogger(FhirCodingGraphBuilder.class);

    private final Coding coding;

    @Override
    public void create() {
        //Add the nodes to the logic graph based on FHIR XML parameters
        //Create root node first
        RootNode root = getRoot();

        AbstractNode node = processCoding(coding);
        root.addChildren(SufficientSet(node));
    }

    public FhirCodingGraphBuilder(final TerminologyStoreDI terminologyStoreDIIn, final Coding codingIn) {
        super(terminologyStoreDIIn);
        coding = codingIn;
    }

    protected AbstractNode processCoding(final Coding coding) {
        //TODO
        return null;
    }
}
