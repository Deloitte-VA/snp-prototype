package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.Media;
import gov.vha.isaac.logic.LogicGraph;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class MediaClassifier extends AbstractFhirClassifier {

    private final Media media;

    public MediaClassifier(final TerminologyStoreDI terminologyStoreDIIn, final Media mediaIn) {
        super(terminologyStoreDIIn);
        media = mediaIn;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected LogicGraph getLogicGraph() {
        throw new UnsupportedOperationException();
    }
}
