package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.Conformance;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class ConformanceClassifier extends AbstractFhirClassifier {

    private final Conformance conformance;

    public ConformanceClassifier(final TerminologyStoreDI terminologyStoreDIIn, final Conformance conformanceIn) {
        super(terminologyStoreDIIn);
        conformance = conformanceIn;
    }

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
