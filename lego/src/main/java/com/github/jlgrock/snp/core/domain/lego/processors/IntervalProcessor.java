package com.github.jlgrock.snp.core.domain.lego.processors;

import com.github.jlgrock.snp.domain.data.ClassifiedPceStore;
import com.github.jlgrock.snp.core.domain.lego.model.Interval;

import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class IntervalProcessor extends AbstractLegoProcessor {


    private final Interval interval;

    IntervalProcessor(final TerminologyStoreDI terminologyStoreDI, final ClassifiedPceStore classPceStore,
                      final Interval intervalIn) {
        super(terminologyStoreDI, classPceStore);
        interval = intervalIn;
    }

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
