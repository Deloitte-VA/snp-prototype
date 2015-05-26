package com.github.jlgrock.snp.core.domain.lego.logicgraph;

import com.github.jlgrock.snp.core.domain.lego.Expression;
import gov.vha.isaac.logic.node.AbstractNode;
import gov.vha.isaac.logic.node.RootNode;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

/**
 * A Logic Graph Builder specific to Lego documents.  This should only be used to
 */
public class ExpressionGraphBuilder extends AbstractLogicGraphBuilder {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ExpressionGraphBuilder.class);

    private Expression expression;


    @Inject
    public ExpressionGraphBuilder(final TerminologyStoreDI terminologyStoreDIIn) {
        super(terminologyStoreDIIn);
    }

    public void expression(final Expression expressionIn) {
        expression = expressionIn;
    }

    @Override
    public void create() {
        // Determine if it is SufficientSet or NecessarySet.  In most cases in Lego, this will be a SufficientSet because
        // all of the primitives have been defined in snomed.

        //Create root node first
        RootNode root = getRoot();

        AbstractNode node = processExpression(expression);
        root.addChildren(SufficientSet(node));
    }


    


}
