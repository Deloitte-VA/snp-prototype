package com.github.jlgrock.snp.core.domain.lego.processors;

import com.github.jlgrock.snp.apis.classifier.LogicalExpressionClassifier;
import com.github.jlgrock.snp.core.domain.lego.model.RelationGroup;
import com.github.jlgrock.snp.domain.data.ClassifiedPceRepository;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;

@Service
public class RelationGroupProcessor extends AbstractLegoProcessor {

    @Inject
    RelationGroupProcessor(final LogicalExpressionClassifier logicalExpressionClassifierIn,
                           final ClassifiedPceStore classPceStore) {
        super(logicalExpressionClassifierIn, classPceStore);
    }

    @Override
    public void process(final Object unmarshalledObject) {
        RelationGroup relationGroup = (RelationGroup) unmarshalledObject;
        throw new UnsupportedOperationException();
    }

    @Override
    public Class processesType() {
        return RelationGroup.class;
    }
}
