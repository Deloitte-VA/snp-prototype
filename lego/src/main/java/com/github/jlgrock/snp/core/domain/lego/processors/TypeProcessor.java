package com.github.jlgrock.snp.core.domain.lego.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.lego.model.Type;
import com.github.jlgrock.snp.domain.data.ClassifiedPceStore;

/**
 *
 */
public class TypeProcessor extends AbstractLegoProcessor {

    private final Type type;

    TypeProcessor(final LogicGraphClassifier logicGraphClassifierIn, final ClassifiedPceStore classPceStore,
                  final Type typeIn) {
        super(logicGraphClassifierIn, classPceStore);
        type = typeIn;
    }

    @Override
    public void process() {
        throw new UnsupportedOperationException();
    }
}
