package com.github.jlgrock.snp.core.data.graphbuilders.fhir;

import com.github.jlgrock.snp.core.data.graphbuilders.AbstractLogicGraphBuilder;
import com.github.jlgrock.snp.core.domain.fhir.Coding;
import gov.vha.isaac.logic.node.AndNode;
import gov.vha.isaac.logic.node.RootNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 */
public class FhirCodeGraphBuilder extends AbstractLogicGraphBuilder {
    private static final Logger LOGGER = LoggerFactory.getLogger(FhirCodeGraphBuilder.class);
    private final Coding coding;
    private static final String IS_ABOUT_SCTID = "53";

    @Override
    public void create() {
        //Add the nodes to the logic graph based on FHIR XML parameters
        //Create root node first
        RootNode root = getRoot();

        String sourceSctId = coding.getCode().getValue();

        //Get NID from UUID
        int sourceConceptNid = getNidFromSNOMED(sourceSctId);
        String destinationSctId = coding.getCode().getValue();

        //Get NID from UUID
        int typeConceptNid = getNidFromSNOMED(IS_ABOUT_SCTID);
        int destinationNid = getNidFromSNOMED(destinationSctId);

        //Create AndNode
        AndNode andNode = And();
        andNode.addChildren(Concept(sourceConceptNid), SomeRole(typeConceptNid, Concept(destinationNid)));
        root.addChildren(SufficientSet(andNode));
    }

    public FhirCodeGraphBuilder(final Coding codingIn) {
        coding = codingIn;
    }
}
