package com.github.jlgrock.snp.core.domain.lego.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.lego.model.AssertionComponent;
import com.github.jlgrock.snp.domain.data.ClassifiedPceStore;

/**
 *
 */
public class AssertionComponentProcessor extends AbstractLegoProcessor {

    private final AssertionComponent assertionComponent;

    AssertionComponentProcessor(final LogicGraphClassifier logicGraphClassifierIn, final ClassifiedPceStore classPceStore,
                                final AssertionComponent assertionComponentIn) {
        super(logicGraphClassifierIn, classPceStore);
        assertionComponent = assertionComponentIn;
    }

    @Override
    public void process() {
        throw new UnsupportedOperationException();
    }
}
