package com.github.jlgrock.snp.core.domain.fhir.logicgraph;

import com.github.jlgrock.snp.core.domain.fhir.Procedure;
import gov.vha.isaac.logic.node.AbstractNode;
import gov.vha.isaac.logic.node.RootNode;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class FhirProcedureGraphBuilder extends AbstractFhirLogicGraphBuilder {
    final Procedure procedure;

    @Override
    public void create() {
        //Add the nodes to the logic graph based on FHIR XML parameters
        //Create root node first
        RootNode root = getRoot();

        AbstractNode node = processProcedure(procedure);
        root.addChildren(SufficientSet(node));
    }

    public FhirProcedureGraphBuilder(final TerminologyStoreDI terminologyStoreDIIn, final Procedure procedureIn) {
        super(terminologyStoreDIIn);
        procedure = procedureIn;
    }

    protected AbstractNode processProcedure(final Procedure procedure) {
        //TODO
        return null;
    }
}
