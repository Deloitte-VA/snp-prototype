package com.github.jlgrock.snp.core.domain.lego.classifiers;

import com.github.jlgrock.snp.core.domain.lego.model.Value;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class ValueClassifier extends AbstractLegoClassifier {

    private final Value value;

    ValueClassifier(final TerminologyStoreDI terminologyStoreDI, final Value valueIn) {
        super(terminologyStoreDI);
        value = valueIn;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
