package com.github.jlgrock.snp.core.domain.lego.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.lego.model.Assertion;
import com.github.jlgrock.snp.domain.data.ClassifiedPceStore;

/**
 *
 */
public class AssertionProcessor extends AbstractLegoProcessor {

    final Assertion assertion;

    AssertionProcessor(final LogicGraphClassifier logicGraphClassifierIn, final ClassifiedPceStore classPceStore,
                       final Assertion assertionIn) {
        super(logicGraphClassifierIn, classPceStore);
        assertion = assertionIn;
    }

    @Override
    public void process() {
        processAssertion(assertion);
    }

}
