package com.github.jlgrock.snp.core.data;

import com.github.jlgrock.snp.core.model.parser.Expression;
import gov.vha.isaac.logic.LogicGraphBuilder;

/**
 * A Logic Graph Builder specific to Lego documents
 */
public class LegoLogicGraphBuilder extends LogicGraphBuilder {

    private final Expression expression;

    /**
     * Set the expression to build the logic graph
     * @param expressionIn the expression to create a logic graph from
     */
    void setExpression(final Expression expressionIn) {
        expression = expressionIn;
    }

    @Override
    public void create() {
        //TODO Prakash's code goes here
    }
}
