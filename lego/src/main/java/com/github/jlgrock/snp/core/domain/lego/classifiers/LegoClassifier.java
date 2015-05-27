package com.github.jlgrock.snp.core.domain.lego.classifiers;

import com.github.jlgrock.snp.core.data.ClassifiedPceStore;
import com.github.jlgrock.snp.core.domain.lego.model.Lego;

import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class LegoClassifier extends AbstractLegoClassifier {

    private final Lego lego;

    LegoClassifier(final TerminologyStoreDI terminologyStoreDI, final ClassifiedPceStore classPceStore,
    		final Lego legoIn) {
        super(terminologyStoreDI, classPceStore);
        lego = legoIn;
    }

    /**
     * {@inheritDoc}
     */
    @Override
	public void classify() {
        parseLego(lego);
    }
}
