package com.github.jlgrock.snp.core.domain.lego.logicgraph;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.lego.model.Expression;
import gov.vha.isaac.logic.LogicGraph;
import gov.vha.isaac.ochre.api.logic.LogicalExpressionBuilder;
import gov.vha.isaac.ochre.api.logic.assertions.Assertion;
import gov.vha.isaac.ochre.api.logic.assertions.connectors.Connector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A Logic Graph Builder specific to Lego documents.  This should only be used to
 */
public class LegoExpressionGraphBuilder extends AbstractLegoLogicGraphBuilder {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LegoExpressionGraphBuilder.class);

    private Expression expression;

    public LegoExpressionGraphBuilder(final LogicGraphClassifier logicGraphClassifierIn, final Expression expressionIn) {
        super(logicGraphClassifierIn);
        expression = expressionIn;
    }

    @Override
    public LogicGraph build() {
        LOGGER.trace("Creating Lego Expression Logic Graph");
        Assertion assertion = buildExpression(expression);
        if (assertion instanceof Connector) {
            LogicalExpressionBuilder.SufficientSet((Connector) assertion);
        } else {
            LogicalExpressionBuilder.SufficientSet(LogicalExpressionBuilder.And(assertion));
        }

        return (LogicGraph) getLogicalExpressionBuilder().build();
    }


}
