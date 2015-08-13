package com.github.jlgrock.snp.core.domain.lego.logicalexpression;

import com.github.jlgrock.snp.apis.classifier.LogicalExpressionClassifier;
import com.github.jlgrock.snp.core.domain.lego.model.Expression;
import gov.vha.isaac.ochre.api.logic.LogicalExpression;
import gov.vha.isaac.ochre.api.logic.LogicalExpressionBuilder;
import gov.vha.isaac.ochre.api.logic.assertions.Assertion;
import gov.vha.isaac.ochre.api.logic.assertions.connectors.Connector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A Logic Graph Builder specific to Lego documents.  This should only be used to
 */
public class LegoLogicalExpressionBuilder extends AbstractLegoLogicalExpressionBuilder {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LegoLogicalExpressionBuilder.class);

    /**
     * Constructor/
     * @param logicalExpressionClassifierIn the classifier for identifying a logical expression.
     */
    public LegoLogicalExpressionBuilder(final LogicalExpressionClassifier logicalExpressionClassifierIn) {
        super(logicalExpressionClassifierIn);
    }

    @Override
    public LogicalExpression build(final Expression expression) {
        LOGGER.trace("Creating Lego Expression Logic Graph");
        Assertion assertion = buildExpression(expression);
        if (assertion instanceof Connector) {
            LogicalExpressionBuilder.SufficientSet((Connector) assertion);
        } else {
            LogicalExpressionBuilder.SufficientSet(LogicalExpressionBuilder.And(assertion));
        }

        return getLogicalExpressionBuilder().build();
    }

}
