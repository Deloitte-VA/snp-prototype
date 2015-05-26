package com.github.jlgrock.snp.core.domain.lego.classifiers;

import com.github.jlgrock.snp.core.domain.lego.Discernible;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class DiscernibleClassifier extends AbstractLegoClassifier {

    private final Discernible discernible;

    DiscernibleClassifier(final TerminologyStoreDI terminologyStoreDI, final Discernible discernibleIn) {
        super(terminologyStoreDI);
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
