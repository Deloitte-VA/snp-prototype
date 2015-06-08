package com.github.jlgrock.snp.core.domain.lego.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.lego.model.Concept;
import com.github.jlgrock.snp.domain.data.ClassifiedPceStore;

/**
 *
 */
public class ConceptProcessor extends AbstractLegoProcessor {

    private final Concept concept;

    ConceptProcessor(final LogicGraphClassifier logicGraphClassifierIn, final ClassifiedPceStore classPceStore,
                     final Concept conceptIn) {
        super(logicGraphClassifierIn, classPceStore);
        concept = conceptIn;
    }

    @Override
    public void process() {
        throw new UnsupportedOperationException();
    }
}
