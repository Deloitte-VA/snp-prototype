package com.github.jlgrock.snp.core.domain.lego.processors;

import com.github.jlgrock.snp.apis.classifier.LogicalExpressionClassifier;
import com.github.jlgrock.snp.core.domain.lego.model.Relation;
import com.github.jlgrock.snp.domain.data.ClassifiedPceRepository;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;

@Service
public class RelationProcessor extends AbstractLegoProcessor {

    @Inject
    RelationProcessor(final LogicalExpressionClassifier logicalExpressionClassifierIn,
                      final ClassifiedPceRepository classifiedPceRepositoryIn) {
        super(logicalExpressionClassifierIn, classifiedPceRepositoryIn);
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
