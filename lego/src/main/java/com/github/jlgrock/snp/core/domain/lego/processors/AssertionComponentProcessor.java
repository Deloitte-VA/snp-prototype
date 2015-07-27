package com.github.jlgrock.snp.core.domain.lego.processors;

import com.github.jlgrock.snp.apis.classifier.LogicalExpressionClassifier;
import com.github.jlgrock.snp.core.domain.lego.model.AssertionComponent;
import com.github.jlgrock.snp.domain.data.ClassifiedPceRepository;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;

@Service
public class AssertionComponentProcessor extends AbstractLegoProcessor {

    @Inject
    AssertionComponentProcessor(final LogicalExpressionClassifier logicalExpressionClassifierIn,
                                final ClassifiedPceRepository classifiedPceRepositoryIn) {
        super(logicalExpressionClassifierIn, classifiedPceRepositoryIn);
    }

    @Override
    public void process(final Object unmarshalledObject) {
        AssertionComponent assertionComponent = (AssertionComponent) unmarshalledObject;
        throw new UnsupportedOperationException();
    }

    @Override
    public Class processesType() {
        return AssertionComponent.class;
    }
}
