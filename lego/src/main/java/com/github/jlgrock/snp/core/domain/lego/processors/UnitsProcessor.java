package com.github.jlgrock.snp.core.domain.lego.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.lego.model.Units;
import com.github.jlgrock.snp.domain.data.ClassifiedPceStore;

/**
 *
 */
public class UnitsProcessor extends AbstractLegoProcessor {

    private final Units units;

    UnitsProcessor(final LogicGraphClassifier logicGraphClassifierIn, final ClassifiedPceStore classPceStore,
                   final Units unitsIn) {
        super(logicGraphClassifierIn, classPceStore);
        units = unitsIn;
    }

    @Override
    public void process() {
        throw new UnsupportedOperationException();
    }
}
