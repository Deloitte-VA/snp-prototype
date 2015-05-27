package com.github.jlgrock.snp.core.domain.lego.classifiers;

import com.github.jlgrock.snp.core.domain.lego.model.Type;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class TypeClassifier extends AbstractLegoClassifier {

    private final Type type;

    TypeClassifier(final TerminologyStoreDI terminologyStoreDI, final Type typeIn) {
        super(terminologyStoreDI);
        type = typeIn;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
