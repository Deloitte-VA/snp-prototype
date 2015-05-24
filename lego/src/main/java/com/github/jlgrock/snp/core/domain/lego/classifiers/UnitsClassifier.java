package com.github.jlgrock.snp.core.domain.lego.classifiers;

import com.github.jlgrock.snp.core.domain.lego.Units;

/**
 *
 */
public class UnitsClassifier extends AbstractLegoClassifier {

    private final Units units;

    UnitsClassifier(final Units unitsIn) {
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
