package com.github.jlgrock.snp.core.domain.lego.classifiers;

import com.github.jlgrock.snp.core.data.ClassifiedPceStore;
import com.github.jlgrock.snp.core.domain.lego.model.Discernible;

import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class DiscernibleClassifier extends AbstractLegoClassifier {

    private final Discernible discernible;

    DiscernibleClassifier(final TerminologyStoreDI terminologyStoreDI, final ClassifiedPceStore classPceStore,
    		final Discernible discernibleIn) {
        super(terminologyStoreDI, classPceStore);
        discernible = discernibleIn;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void classify() {
        parseDiscernible(discernible);
    }
}
