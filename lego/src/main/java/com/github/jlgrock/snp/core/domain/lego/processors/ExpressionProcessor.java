package com.github.jlgrock.snp.core.domain.lego.processors;

import com.github.jlgrock.snp.domain.data.ClassifiedPceStore;
import com.github.jlgrock.snp.core.domain.lego.model.Expression;

import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class ExpressionProcessor extends AbstractLegoProcessor {

    private final Expression expression;

    ExpressionProcessor(TerminologyStoreDI terminologyStoreDI, final ClassifiedPceStore classPceStore,
                        final Expression expressionIn) {
        super(terminologyStoreDI, classPceStore);
        expression = expressionIn;
    }

    @Override
    public void classify() {
        parseExpression(expression);
    }
}
