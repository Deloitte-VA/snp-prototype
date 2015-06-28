package com.github.jlgrock.snp.core.domain.lego.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.lego.model.Expression;
import com.github.jlgrock.snp.domain.data.ClassifiedPceStore;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;

@Service
public class ExpressionProcessor extends AbstractLegoProcessor {

    @Inject
    ExpressionProcessor(final LogicGraphClassifier logicGraphClassifierIn,
                        final ClassifiedPceStore classPceStore) {
        super(logicGraphClassifierIn, classPceStore);
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
