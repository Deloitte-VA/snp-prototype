package com.github.jlgrock.snp.core.domain.lego.processors;

import com.github.jlgrock.snp.apis.classifier.LogicalExpressionClassifier;
import com.github.jlgrock.snp.core.domain.lego.logicalexpression.LegoLogicalExpressionBuilder;
import com.github.jlgrock.snp.core.domain.lego.model.Relation;
import com.github.jlgrock.snp.domain.data.ClassifiedPceRepository;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;

@Service
public class RelationProcessor extends AbstractLegoProcessor {

    @Inject
    RelationProcessor(final LogicalExpressionClassifier logicalExpressionClassifierIn,
                      final ClassifiedPceRepository classifiedPceRepositoryIn,
                      final LegoLogicalExpressionBuilder legoLogicalExpressionBuilderIn) {
        super(logicalExpressionClassifierIn, classifiedPceRepositoryIn, legoLogicalExpressionBuilderIn);
    }

    @Override
    public void process(final Object unmarshalledObject) {
        Relation relation = (Relation) unmarshalledObject;
        throw new UnsupportedOperationException();
    }

    @Override
    public Class processesType() {
        return Relation.class;
    }
}
