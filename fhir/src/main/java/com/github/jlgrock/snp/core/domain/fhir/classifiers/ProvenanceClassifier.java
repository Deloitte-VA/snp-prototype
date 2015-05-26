package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.Provenance;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class ProvenanceClassifier extends AbstractFhirClassifier {

    private final Provenance provenance;

    public ProvenanceClassifier(final TerminologyStoreDI terminologyStoreDIIn, final Provenance provenanceIn) {
        super(terminologyStoreDIIn);
        provenance = provenanceIn;
    }

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
