package com.github.jlgrock.snp.core.domain.lego.classifiers;

import com.github.jlgrock.snp.core.domain.lego.RelationGroup;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class RelationGroupClassifier extends AbstractLegoClassifier {

    private final RelationGroup relationGroup;

    RelationGroupClassifier(final TerminologyStoreDI terminologyStoreDI, final RelationGroup relationGroupIn) {
        super(terminologyStoreDI);
        relationGroup = relationGroupIn;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
