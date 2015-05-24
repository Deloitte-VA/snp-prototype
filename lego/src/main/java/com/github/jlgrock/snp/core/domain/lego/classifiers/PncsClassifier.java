package com.github.jlgrock.snp.core.domain.lego.classifiers;

import com.github.jlgrock.snp.core.domain.lego.Pncs;

/**
 *
 */
public class PncsClassifier extends AbstractLegoClassifier {

    private final Pncs pncs;

    PncsClassifier(final Pncs pncsIn) {
        pncs = pncsIn;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void classify() {
        parsePncs(pncs);
    }
}
