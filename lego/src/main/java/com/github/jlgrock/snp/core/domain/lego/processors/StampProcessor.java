package com.github.jlgrock.snp.core.domain.lego.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.lego.model.Stamp;
import com.github.jlgrock.snp.domain.data.ClassifiedPceStore;

/**
 *
 */
public class StampProcessor extends AbstractLegoProcessor {

    private final Stamp stamp;

    StampProcessor(final LogicGraphClassifier logicGraphClassifierIn, final ClassifiedPceStore classPceStore,
                   final Stamp stampIn) {
        super(logicGraphClassifierIn, classPceStore);
        stamp = stampIn;
    }

    @Override
    public void process() {
        throw new UnsupportedOperationException();
    }
}
