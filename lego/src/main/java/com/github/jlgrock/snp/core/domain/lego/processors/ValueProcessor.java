package com.github.jlgrock.snp.core.domain.lego.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.lego.model.Value;
import com.github.jlgrock.snp.domain.data.ClassifiedPceStore;

/**
 *
 */
public class ValueProcessor extends AbstractLegoProcessor {

    private final Value value;

    ValueProcessor(final LogicGraphClassifier logicGraphClassifierIn, final ClassifiedPceStore classPceStore,
                   final Value valueIn) {
        super(logicGraphClassifierIn, classPceStore);
        value = valueIn;
    }

    @Override
    public void process() {
        throw new UnsupportedOperationException();
    }
}
