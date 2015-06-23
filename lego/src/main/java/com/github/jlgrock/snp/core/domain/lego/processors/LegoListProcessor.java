package com.github.jlgrock.snp.core.domain.lego.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.lego.model.LegoList;
import com.github.jlgrock.snp.domain.data.ClassifiedPceStore;

/**
 *
 */
public class LegoListProcessor extends AbstractLegoProcessor {

    private final LegoList legoList;

    LegoListProcessor(final LogicGraphClassifier logicGraphClassifierIn, final ClassifiedPceStore classPceStore,
                      final LegoList legoListIn) {
        super(logicGraphClassifierIn, classPceStore);
        legoList = legoListIn;
    }

    @Override
    public void process() {
        processLegoList(legoList);
    }
}
