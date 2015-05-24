package com.github.jlgrock.snp.core.domain.lego.classifiers;

import com.github.jlgrock.snp.core.domain.lego.Lego;

/**
 *
 */
public class LegoClassifier extends AbstractLegoClassifier {

    private final Lego lego;

    LegoClassifier(final Lego legoIn) {
        lego = legoIn;
    }

    /**
     * {@inheritDoc}
     */
    public void classify() {
        parseLego(lego);
    }
}
