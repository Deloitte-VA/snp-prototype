package com.github.jlgrock.snp.core.domain.lego.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.lego.model.Qualifier;
import com.github.jlgrock.snp.domain.data.ClassifiedPceStore;

/**
 *
 */
public class QualifierProcessor extends AbstractLegoProcessor {

    private final Qualifier qualifier;

    QualifierProcessor(final LogicGraphClassifier logicGraphClassifierIn, final ClassifiedPceStore classPceStore,
                       final Qualifier qualifierIn) {
        super(logicGraphClassifierIn, classPceStore);
        qualifier = qualifierIn;
    }

    @Override
    public void process() {
        throw new UnsupportedOperationException();
    }
}
