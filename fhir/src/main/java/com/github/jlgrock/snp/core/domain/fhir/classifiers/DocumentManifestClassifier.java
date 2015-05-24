package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.DocumentManifest;

/**
 *
 */
public class DocumentManifestClassifier extends AbstractFhirClassifier {

    private final DocumentManifest documentManifest;

    public DocumentManifestClassifier(final DocumentManifest documentManifestIn) {
        documentManifest = documentManifestIn;
    }

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
