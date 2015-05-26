package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.Composition;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class CompositionClassifier extends AbstractFhirClassifier {

    private final Composition composition;

    public CompositionClassifier(final TerminologyStoreDI terminologyStoreDIIn, final Composition compositionIn) {
        super(terminologyStoreDIIn);
        composition = compositionIn;
    }

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
