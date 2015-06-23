package com.github.jlgrock.snp.core.domain.lego.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.lego.model.Pncs;
import com.github.jlgrock.snp.domain.data.ClassifiedPceStore;

/**
 *
 */
public class PncsProcessor extends AbstractLegoProcessor {

    private final Pncs pncs;

    PncsProcessor(final LogicGraphClassifier logicGraphClassifierIn, final ClassifiedPceStore classPceStore,
                  final Pncs pncsIn) {
        super(logicGraphClassifierIn, classPceStore);
        pncs = pncsIn;
    }

    @Override
    public void process() {
        processPncs(pncs);
    }
}
