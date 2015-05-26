package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.Provenance;
import gov.vha.isaac.logic.LogicGraph;
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

    /**
     * {@inheritDoc}
     */
    @Override
    protected LogicGraph getLogicGraph() {
        throw new UnsupportedOperationException();
    }
}
