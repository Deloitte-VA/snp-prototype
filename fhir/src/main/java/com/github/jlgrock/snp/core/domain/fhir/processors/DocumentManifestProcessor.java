package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.core.domain.fhir.model.DocumentManifest;

import gov.vha.isaac.logic.LogicGraph;

import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class DocumentManifestProcessor extends AbstractFhirProcessor {

    private final DocumentManifest documentManifest;

    public DocumentManifestProcessor(final TerminologyStoreDI terminologyStoreDIIn, final DocumentManifest documentManifestIn) {
        super(terminologyStoreDIIn);
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
