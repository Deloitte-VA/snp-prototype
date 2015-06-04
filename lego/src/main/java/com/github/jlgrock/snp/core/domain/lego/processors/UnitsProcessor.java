package com.github.jlgrock.snp.core.domain.lego.processors;

import com.github.jlgrock.snp.domain.data.ClassifiedPceStore;
import com.github.jlgrock.snp.core.domain.lego.model.Units;

import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class UnitsProcessor extends AbstractLegoProcessor {

    private final Units units;

    UnitsProcessor(final TerminologyStoreDI terminologyStoreDI, final ClassifiedPceStore classPceStore,
                   final Units unitsIn) {
        super(terminologyStoreDI, classPceStore);
        units = unitsIn;
    }

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
