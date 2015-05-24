package com.github.jlgrock.snp.core.domain.lego.classifiers;

import com.github.jlgrock.snp.core.domain.lego.LegoList;

/**
 *
 */
public class LegoListClassifier extends AbstractLegoClassifier {

    private final LegoList legoList;

    LegoListClassifier(final LegoList legoListIn) {
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
