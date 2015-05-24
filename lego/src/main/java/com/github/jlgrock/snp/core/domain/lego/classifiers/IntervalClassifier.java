package com.github.jlgrock.snp.core.domain.lego.classifiers;

import com.github.jlgrock.snp.core.domain.lego.Interval;

/**
 *
 */
public class IntervalClassifier extends AbstractLegoClassifier {


    private final Interval interval;

    IntervalClassifier(final Interval intervalIn) {
        interval = intervalIn;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
