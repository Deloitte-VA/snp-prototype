package com.github.jlgrock.snp.core.domain.lego.classifiers;

import com.github.jlgrock.snp.domain.data.ClassifiedPceStore;
import com.github.jlgrock.snp.core.domain.lego.model.Pncs;

import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class PncsClassifier extends AbstractLegoClassifier {

    private final Pncs pncs;

    PncsClassifier(final TerminologyStoreDI terminologyStoreDI, final ClassifiedPceStore classPceStore,
    		final Pncs pncsIn) {
        super(terminologyStoreDI, classPceStore);
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
