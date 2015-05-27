package com.github.jlgrock.snp.core.domain.lego.classifiers;

import com.github.jlgrock.snp.core.domain.lego.model.Expression;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class ExpressionClassifier extends AbstractLegoClassifier {

    private final Expression expression;

    ExpressionClassifier(TerminologyStoreDI terminologyStoreDI, final Expression expressionIn) {
        super(terminologyStoreDI);
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
