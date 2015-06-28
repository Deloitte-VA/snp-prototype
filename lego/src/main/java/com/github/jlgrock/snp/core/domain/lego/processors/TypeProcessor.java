package com.github.jlgrock.snp.core.domain.lego.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.lego.model.Type;
import com.github.jlgrock.snp.domain.data.ClassifiedPceStore;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;

@Service
public class TypeProcessor extends AbstractLegoProcessor {

    @Inject
    TypeProcessor(final LogicGraphClassifier logicGraphClassifierIn,
                  final ClassifiedPceStore classPceStore) {
        super(logicGraphClassifierIn, classPceStore);
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
