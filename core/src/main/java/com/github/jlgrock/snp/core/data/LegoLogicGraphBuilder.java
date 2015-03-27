package com.github.jlgrock.snp.core.data;

import com.github.jlgrock.snp.core.model.parser.Expression;
import gov.vha.isaac.logic.LogicGraph;
import gov.vha.isaac.logic.LogicGraphBuilder;

/**
 * A Logic Graph Builder specific to Lego documents
 */
public class LegoLogicGraphBuilder extends LogicGraphBuilder {

    private Expression expression;
    private LogicGraph logicGraph;

    /**
     * Set the expression to build the logic graph
     * @param expressionIn the expression to create a logic graph from
     */
    public void setExpression(final Expression expressionIn) {
        expression = expressionIn;
    }

    @Override
    public void create() {
        //TODO Prakash's code goes here
    }

    public LogicGraph getLogicGraph() {
        return logicGraph;
    }
}
