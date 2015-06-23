package com.github.jlgrock.snp.core.domain.lego.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.lego.model.Expression;
import com.github.jlgrock.snp.domain.data.ClassifiedPceStore;

/**
 *
 */
public class ExpressionProcessor extends AbstractLegoProcessor {

    private final Expression expression;

    ExpressionProcessor(final LogicGraphClassifier logicGraphClassifierIn, final ClassifiedPceStore classPceStore,
                        final Expression expressionIn) {
        super(logicGraphClassifierIn, classPceStore);
        expression = expressionIn;
    }

    @Override
    public void process() {
        processExpression(expression);
    }
}
