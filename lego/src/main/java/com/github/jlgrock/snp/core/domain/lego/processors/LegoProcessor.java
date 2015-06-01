package com.github.jlgrock.snp.core.domain.lego.processors;

import com.github.jlgrock.snp.domain.data.ClassifiedPceStore;
import com.github.jlgrock.snp.core.domain.lego.model.Lego;

import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class LegoProcessor extends AbstractLegoProcessor {

    private final Lego lego;

    LegoProcessor(final TerminologyStoreDI terminologyStoreDI, final ClassifiedPceStore classPceStore,
                  final Lego legoIn) {
        super(terminologyStoreDI, classPceStore);
        lego = legoIn;
    }

    @Override
	public void classify() {
        parseLego(lego);
    }
}
