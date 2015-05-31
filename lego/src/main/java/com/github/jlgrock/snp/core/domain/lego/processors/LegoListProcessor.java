package com.github.jlgrock.snp.core.domain.lego.processors;

import com.github.jlgrock.snp.domain.data.ClassifiedPceStore;
import com.github.jlgrock.snp.core.domain.lego.model.LegoList;

import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class LegoListProcessor extends AbstractLegoProcessor {

    private final LegoList legoList;

    LegoListProcessor(final TerminologyStoreDI terminologyStoreDI, final ClassifiedPceStore classPceStore,
                      final LegoList legoListIn) {
        super(terminologyStoreDI, classPceStore);
        legoList = legoListIn;
    }

    @Override
    public void classify() {
        parseLegoList(legoList);
    }
}
