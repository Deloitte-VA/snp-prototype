package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.DocumentManifest;
import gov.vha.isaac.logic.LogicGraph;

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
    protected LogicGraph getLogicGraph() {
        throw new UnsupportedOperationException();
    }

	@Override
	public void process() {
		throw new UnsupportedOperationException();
		
	}

}
