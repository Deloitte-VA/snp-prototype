package com.github.jlgrock.snp.core.domain.lego.processors;

import com.github.jlgrock.snp.domain.data.ClassifiedPceStore;
import com.github.jlgrock.snp.core.domain.lego.model.Assertion;

import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class AssertionProcessor extends AbstractLegoProcessor {

    final Assertion assertion;

    AssertionProcessor(final TerminologyStoreDI terminologyStoreDI, final ClassifiedPceStore classPceStore,
                       final Assertion assertionIn) {
        super(terminologyStoreDI, classPceStore);
        assertion = assertionIn;
    }

    @Override
    public void classify() {
        parseAssertion(assertion);
    }

}
