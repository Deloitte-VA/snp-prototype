package com.github.jlgrock.snp.core.domain.lego.classifiers;

import com.github.jlgrock.snp.core.data.ClassifiedPceStore;
import com.github.jlgrock.snp.core.domain.lego.model.LegoList;

import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class LegoListClassifier extends AbstractLegoClassifier {

    private final LegoList legoList;

    LegoListClassifier(final TerminologyStoreDI terminologyStoreDI, final ClassifiedPceStore classPceStore, 
    		final LegoList legoListIn) {
        super(terminologyStoreDI, classPceStore);
        legoList = legoListIn;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void classify() {
        parseLegoList(legoList);
    }
}
