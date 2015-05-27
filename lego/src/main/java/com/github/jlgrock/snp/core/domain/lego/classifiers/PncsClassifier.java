package com.github.jlgrock.snp.core.domain.lego.classifiers;

import com.github.jlgrock.snp.core.domain.lego.model.Pncs;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class PncsClassifier extends AbstractLegoClassifier {

    private final Pncs pncs;

    PncsClassifier(final TerminologyStoreDI terminologyStoreDI, final Pncs pncsIn) {
        super(terminologyStoreDI);
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
