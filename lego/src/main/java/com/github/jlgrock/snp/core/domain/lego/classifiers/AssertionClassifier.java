package com.github.jlgrock.snp.core.domain.lego.classifiers;

import com.github.jlgrock.snp.core.domain.lego.Assertion;

/**
 *
 */
public class AssertionClassifier extends AbstractLegoClassifier {

    final Assertion assertion;

    AssertionClassifier(final Assertion assertionIn) {
        assertion = assertionIn;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void classify() {
        parseAssertion(assertion);
    }

}
