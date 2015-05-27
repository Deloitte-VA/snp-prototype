package com.github.jlgrock.snp.core.domain.lego.classifiers;

import com.github.jlgrock.snp.core.data.ClassifiedPceStore;
import com.github.jlgrock.snp.core.domain.lego.Expression;

import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class ExpressionClassifier extends AbstractLegoClassifier {

    private final Expression expression;

    ExpressionClassifier(TerminologyStoreDI terminologyStoreDI, final ClassifiedPceStore classPceStore,
    		final Expression expressionIn) {
        super(terminologyStoreDI, classPceStore);
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
