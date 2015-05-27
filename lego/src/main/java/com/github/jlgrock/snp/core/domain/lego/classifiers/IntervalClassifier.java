package com.github.jlgrock.snp.core.domain.lego.classifiers;

import com.github.jlgrock.snp.core.domain.lego.model.Interval;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class IntervalClassifier extends AbstractLegoClassifier {


    private final Interval interval;

    IntervalClassifier(final TerminologyStoreDI terminologyStoreDI, final Interval intervalIn) {
        super(terminologyStoreDI);
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
