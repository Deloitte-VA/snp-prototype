package com.github.jlgrock.snp.core.domain.lego.processors;

import com.github.jlgrock.snp.domain.data.ClassifiedPceStore;
import com.github.jlgrock.snp.core.domain.lego.model.Relation;

import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class RelationProcessor extends AbstractLegoProcessor {

    private final Relation relation;

    RelationProcessor(final TerminologyStoreDI terminologyStoreDI, final ClassifiedPceStore classPceStore,
                      final Relation relationIn) {
        super(terminologyStoreDI, classPceStore);
        relation = relationIn;
    }

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
