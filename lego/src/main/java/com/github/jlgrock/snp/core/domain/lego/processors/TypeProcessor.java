package com.github.jlgrock.snp.core.domain.lego.processors;

import com.github.jlgrock.snp.domain.data.ClassifiedPceStore;
import com.github.jlgrock.snp.core.domain.lego.model.Type;

import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class TypeProcessor extends AbstractLegoProcessor {

    private final Type type;

    TypeProcessor(final TerminologyStoreDI terminologyStoreDI, final ClassifiedPceStore classPceStore,
                  final Type typeIn) {
        super(terminologyStoreDI, classPceStore);
        type = typeIn;
    }

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
