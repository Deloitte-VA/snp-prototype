package com.github.jlgrock.snp.core.domain.lego.classifiers;

import com.github.jlgrock.snp.core.data.ClassifiedPceStore;
import com.github.jlgrock.snp.core.domain.lego.Assertion;

import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class AssertionClassifier extends AbstractLegoClassifier {

    final Assertion assertion;

    AssertionClassifier(final TerminologyStoreDI terminologyStoreDI, final ClassifiedPceStore classPceStore,
    		final Assertion assertionIn) {
        super(terminologyStoreDI, classPceStore);
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
