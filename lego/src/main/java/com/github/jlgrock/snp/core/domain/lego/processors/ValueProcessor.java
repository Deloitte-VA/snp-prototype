package com.github.jlgrock.snp.core.domain.lego.processors;

import com.github.jlgrock.snp.domain.data.ClassifiedPceStore;
import com.github.jlgrock.snp.core.domain.lego.model.Value;

import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class ValueProcessor extends AbstractLegoProcessor {

    private final Value value;

    ValueProcessor(final TerminologyStoreDI terminologyStoreDI, final ClassifiedPceStore classPceStore,
                   final Value valueIn) {
        super(terminologyStoreDI, classPceStore);
        value = valueIn;
    }

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
