package com.github.jlgrock.snp.core.domain.lego.processors;

import com.github.jlgrock.snp.domain.data.ClassifiedPceStore;
import com.github.jlgrock.snp.core.domain.lego.model.Concept;

import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class ConceptProcessor extends AbstractLegoProcessor {

    private final Concept concept;

    ConceptProcessor(final TerminologyStoreDI terminologyStoreDI, final ClassifiedPceStore classPceStore,
                     final Concept conceptIn) {
        super(terminologyStoreDI, classPceStore);
        concept = conceptIn;
    }

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
