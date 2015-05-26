package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.DocumentManifest;
import gov.vha.isaac.logic.LogicGraph;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class DocumentManifestClassifier extends AbstractFhirClassifier {

    private final DocumentManifest documentManifest;

    public DocumentManifestClassifier(final TerminologyStoreDI terminologyStoreDIIn, final DocumentManifest documentManifestIn) {
        super(terminologyStoreDIIn);
        documentManifest = documentManifestIn;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected LogicGraph getLogicGraph() {
        throw new UnsupportedOperationException();
    }

}
