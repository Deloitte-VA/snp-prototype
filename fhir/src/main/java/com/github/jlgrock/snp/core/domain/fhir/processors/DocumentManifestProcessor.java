package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.DocumentManifest;

/**
 *
 */
public class DocumentManifestProcessor extends AbstractFhirProcessor {

    private final DocumentManifest documentManifest;

    public DocumentManifestProcessor(final LogicGraphClassifier logicGraphClassifierIn, final DocumentManifest documentManifestIn) {
        super(logicGraphClassifierIn);
        documentManifest = documentManifestIn;
    }

	@Override
	public void process(final String identifier) {
		throw new UnsupportedOperationException();
		
	}

}
