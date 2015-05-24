package com.github.jlgrock.snp.core.domain.lego.classifiers;

import com.github.jlgrock.snp.core.domain.lego.Discernible;

/**
 *
 */
public class DiscernibleClassifier extends AbstractLegoClassifier {

    private final Discernible discernible;

    DiscernibleClassifier(final Discernible discernibleIn) {
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
