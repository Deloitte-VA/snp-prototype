package com.github.jlgrock.snp.core.domain.lego.processors;

import com.github.jlgrock.snp.apis.classifier.LogicalExpressionClassifier;
import com.github.jlgrock.snp.core.domain.lego.logicalexpression.LegoLogicalExpressionBuilder;
import com.github.jlgrock.snp.core.domain.lego.model.Type;
import com.github.jlgrock.snp.domain.data.ClassifiedPceRepository;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;

@Service
public class TypeProcessor extends AbstractLegoProcessor {

    @Inject
    TypeProcessor(final LogicalExpressionClassifier logicalExpressionClassifierIn,
                  final ClassifiedPceRepository classifiedPceRepositoryIn,
                  final LegoLogicalExpressionBuilder legoLogicalExpressionBuilderIn) {
        super(logicalExpressionClassifierIn, classifiedPceRepositoryIn, legoLogicalExpressionBuilderIn);
    }

    @Override
    public void process(final Object unmarshalledObject) {
        Type type = (Type) unmarshalledObject;
        throw new UnsupportedOperationException();
    }

    @Override
    public Class processesType() {
        return Type.class;
    }
}
