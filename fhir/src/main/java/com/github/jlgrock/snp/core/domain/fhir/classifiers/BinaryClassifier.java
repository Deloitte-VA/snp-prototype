package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.Binary;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class BinaryClassifier extends AbstractFhirClassifier {

    private final Binary binary;

    public BinaryClassifier(final TerminologyStoreDI terminologyStoreDIIn, final Binary binaryIn) {
        super(terminologyStoreDIIn);
        binary = binaryIn;
    }

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
