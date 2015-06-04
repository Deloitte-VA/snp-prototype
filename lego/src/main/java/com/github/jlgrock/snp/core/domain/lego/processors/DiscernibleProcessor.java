package com.github.jlgrock.snp.core.domain.lego.processors;

import com.github.jlgrock.snp.domain.data.ClassifiedPceStore;
import com.github.jlgrock.snp.core.domain.lego.model.Discernible;

import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class DiscernibleProcessor extends AbstractLegoProcessor {

    private final Discernible discernible;

    DiscernibleProcessor(final TerminologyStoreDI terminologyStoreDI, final ClassifiedPceStore classPceStore,
                         final Discernible discernibleIn) {
        super(terminologyStoreDI, classPceStore);
        discernible = discernibleIn;
    }

    @Override
    public void classify() {
        parseDiscernible(discernible);
    }
}
