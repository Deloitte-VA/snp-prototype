package com.github.jlgrock.snp.core.domain.lego.processors;

import com.github.jlgrock.snp.apis.classifier.LogicalExpressionClassifier;
import com.github.jlgrock.snp.core.domain.lego.model.Stamp;
import com.github.jlgrock.snp.domain.data.ClassifiedPceRepository;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;

@Service
public class StampProcessor extends AbstractLegoProcessor {

    @Inject
    StampProcessor(final LogicalExpressionClassifier logicalExpressionClassifierIn,
                   final ClassifiedPceStore classPceStore) {
        super(logicalExpressionClassifierIn, classPceStore);
    }

    @Override
    public void process(final Object unmarshalledObject) {
        Stamp stamp = (Stamp) unmarshalledObject;
        throw new UnsupportedOperationException();
    }

    @Override
    public Class processesType() {
        return Stamp.class;
    }
}
