package com.github.jlgrock.snp.core.domain.lego.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.lego.model.Discernible;
import com.github.jlgrock.snp.domain.data.ClassifiedPceStore;

/**
 *
 */
public class DiscernibleProcessor extends AbstractLegoProcessor {

    private final Discernible discernible;

    DiscernibleProcessor(final LogicGraphClassifier logicGraphClassifierIn, final ClassifiedPceStore classPceStore,
                         final Discernible discernibleIn) {
        super(logicGraphClassifierIn, classPceStore);
        discernible = discernibleIn;
    }

    @Override
    public void process() {
        processDiscernible(discernible);
    }
}
