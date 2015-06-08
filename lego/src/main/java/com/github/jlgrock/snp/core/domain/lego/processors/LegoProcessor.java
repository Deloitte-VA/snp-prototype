package com.github.jlgrock.snp.core.domain.lego.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.lego.model.Lego;
import com.github.jlgrock.snp.domain.data.ClassifiedPceStore;

/**
 *
 */
public class LegoProcessor extends AbstractLegoProcessor {

    private final Lego lego;

    LegoProcessor(final LogicGraphClassifier logicGraphClassifierIn, final ClassifiedPceStore classPceStore,
                  final Lego legoIn) {
        super(logicGraphClassifierIn, classPceStore);
        lego = legoIn;
    }

    @Override
	public void process() {
        processLego(lego);
    }
}
