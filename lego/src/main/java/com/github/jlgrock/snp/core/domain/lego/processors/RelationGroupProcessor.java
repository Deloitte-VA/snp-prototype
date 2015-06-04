package com.github.jlgrock.snp.core.domain.lego.processors;

import com.github.jlgrock.snp.domain.data.ClassifiedPceStore;
import com.github.jlgrock.snp.core.domain.lego.model.RelationGroup;

import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class RelationGroupProcessor extends AbstractLegoProcessor {

    private final RelationGroup relationGroup;

    RelationGroupProcessor(final TerminologyStoreDI terminologyStoreDI, final ClassifiedPceStore classPceStore,
                           final RelationGroup relationGroupIn) {
        super(terminologyStoreDI, classPceStore);
        relationGroup = relationGroupIn;
    }

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
