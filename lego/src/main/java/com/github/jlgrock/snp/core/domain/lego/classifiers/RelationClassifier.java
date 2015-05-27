package com.github.jlgrock.snp.core.domain.lego.classifiers;

import com.github.jlgrock.snp.core.data.ClassifiedPceStore;
import com.github.jlgrock.snp.core.domain.lego.model.Relation;

import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class RelationClassifier extends AbstractLegoClassifier {

    private final Relation relation;

    RelationClassifier(final TerminologyStoreDI terminologyStoreDI, final ClassifiedPceStore classPceStore,
    		final Relation relationIn) {
        super(terminologyStoreDI, classPceStore);
        relation = relationIn;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
