package com.github.jlgrock.snp.core.domain.lego.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.lego.model.RelationGroup;
import com.github.jlgrock.snp.domain.data.ClassifiedPceStore;

/**
 *
 */
public class RelationGroupProcessor extends AbstractLegoProcessor {

    private final RelationGroup relationGroup;

    RelationGroupProcessor(final LogicGraphClassifier logicGraphClassifierIn, final ClassifiedPceStore classPceStore,
                           final RelationGroup relationGroupIn) {
        super(logicGraphClassifierIn, classPceStore);
        relationGroup = relationGroupIn;
    }

    @Override
    public void process() {
        throw new UnsupportedOperationException();
    }
}
