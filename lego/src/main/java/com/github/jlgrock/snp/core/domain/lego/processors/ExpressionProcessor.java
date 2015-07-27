package com.github.jlgrock.snp.core.domain.lego.processors;

import com.github.jlgrock.snp.apis.classifier.LogicalExpressionClassifier;
import com.github.jlgrock.snp.core.domain.lego.model.Expression;
import com.github.jlgrock.snp.domain.data.ClassifiedPceRepository;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;

@Service
public class ExpressionProcessor extends AbstractLegoProcessor {

    @Inject
    ExpressionProcessor(final LogicalExpressionClassifier logicalExpressionClassifierIn,
                        final ClassifiedPceStore classPceStore) {
        super(logicalExpressionClassifierIn, classPceStore);
    }

    @Override
    public void process(final Object unmarshalledObject) {
        Expression expression = (Expression) unmarshalledObject;
        processExpression(expression);
    }

    @Override
    public Class processesType() {
        return Expression.class;
    }
}
