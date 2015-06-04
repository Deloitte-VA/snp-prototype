package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.core.domain.fhir.model.Media;
import gov.vha.isaac.logic.LogicGraph;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class MediaProcessor extends AbstractFhirProcessor {

    private final Media media;

    public MediaProcessor(final TerminologyStoreDI terminologyStoreDIIn, final Media mediaIn) {
        super(terminologyStoreDIIn);
        media = mediaIn;
    }

    @Override
    protected LogicGraph getLogicGraph() {
        throw new UnsupportedOperationException();
    }
}
