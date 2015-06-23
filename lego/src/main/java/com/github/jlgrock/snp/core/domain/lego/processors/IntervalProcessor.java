package com.github.jlgrock.snp.core.domain.lego.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.lego.model.Interval;
import com.github.jlgrock.snp.domain.data.ClassifiedPceStore;

/**
 *
 */
public class IntervalProcessor extends AbstractLegoProcessor {


    private final Interval interval;

    IntervalProcessor(final LogicGraphClassifier logicGraphClassifierIn, final ClassifiedPceStore classPceStore,
                      final Interval intervalIn) {
        super(logicGraphClassifierIn, classPceStore);
        interval = intervalIn;
    }

    @Override
    public void process() {
        throw new UnsupportedOperationException();
    }
}
