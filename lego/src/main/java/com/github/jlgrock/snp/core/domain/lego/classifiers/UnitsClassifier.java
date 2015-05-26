package com.github.jlgrock.snp.core.domain.lego.classifiers;

import com.github.jlgrock.snp.core.domain.lego.Units;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class UnitsClassifier extends AbstractLegoClassifier {

    private final Units units;

    UnitsClassifier(final TerminologyStoreDI terminologyStoreDI, final Units unitsIn) {
        super(terminologyStoreDI);
        units = unitsIn;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
