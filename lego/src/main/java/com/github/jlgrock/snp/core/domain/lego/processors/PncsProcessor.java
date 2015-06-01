package com.github.jlgrock.snp.core.domain.lego.processors;

import com.github.jlgrock.snp.domain.data.ClassifiedPceStore;
import com.github.jlgrock.snp.core.domain.lego.model.Pncs;

import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class PncsProcessor extends AbstractLegoProcessor {

    private final Pncs pncs;

    PncsProcessor(final TerminologyStoreDI terminologyStoreDI, final ClassifiedPceStore classPceStore,
                  final Pncs pncsIn) {
        super(terminologyStoreDI, classPceStore);
        pncs = pncsIn;
    }

    @Override
    public void classify() {
        parsePncs(pncs);
    }
}
