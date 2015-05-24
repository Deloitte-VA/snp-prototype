package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.Provenance;

/**
 *
 */
public class ProvenanceClassifier extends AbstractFhirClassifier {

    private final Provenance provenance;

    public ProvenanceClassifier(final Provenance provenanceIn) {
        provenance = provenanceIn;
    }

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
