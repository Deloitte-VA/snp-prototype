package com.github.jlgrock.snp.core.domain.lego.classifiers;

import com.github.jlgrock.snp.core.domain.lego.Expression;

/**
 *
 */
public class ExpressionClassifier extends AbstractLegoClassifier {

    private final Expression expression;

    ExpressionClassifier(final Expression expressionIn) {
        expression = expressionIn;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void classify() {
        parseExpression(expression);
    }
}
