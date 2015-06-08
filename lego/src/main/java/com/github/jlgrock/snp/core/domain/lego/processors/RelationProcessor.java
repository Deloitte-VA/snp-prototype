package com.github.jlgrock.snp.core.domain.lego.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.lego.model.Relation;
import com.github.jlgrock.snp.domain.data.ClassifiedPceStore;

/**
 *
 */
public class RelationProcessor extends AbstractLegoProcessor {

    private final Relation relation;

    RelationProcessor(final LogicGraphClassifier logicGraphClassifierIn, final ClassifiedPceStore classPceStore,
                      final Relation relationIn) {
        super(logicGraphClassifierIn, classPceStore);
        relation = relationIn;
    }

    @Override
    public void process() {
        throw new UnsupportedOperationException();
    }
}
