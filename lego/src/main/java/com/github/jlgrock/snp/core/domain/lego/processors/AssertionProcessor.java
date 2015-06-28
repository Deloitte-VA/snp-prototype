package com.github.jlgrock.snp.core.domain.lego.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.lego.model.Assertion;
import com.github.jlgrock.snp.domain.data.ClassifiedPceStore;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;

@Service
public class AssertionProcessor extends AbstractLegoProcessor {

    @Inject
    AssertionProcessor(final LogicGraphClassifier logicGraphClassifierIn,
                       final ClassifiedPceStore classPceStore) {
        super(logicGraphClassifierIn, classPceStore);
    }

    @Override
    public void process(final Object unmarshalledObject) {
        Assertion assertion = (Assertion) unmarshalledObject;
        processAssertion(assertion);
    }

    @Override
    public Class processesType() {
        return Assertion.class;
    }

}
