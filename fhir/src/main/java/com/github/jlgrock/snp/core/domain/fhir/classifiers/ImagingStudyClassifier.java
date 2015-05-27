package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.model.ImagingStudy;
import gov.vha.isaac.logic.LogicGraph;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class ImagingStudyClassifier extends AbstractFhirClassifier {

    private final ImagingStudy imagingStudy;

    public ImagingStudyClassifier(final TerminologyStoreDI terminologyStoreDIIn, final ImagingStudy imagingStudyIn) {
        super(terminologyStoreDIIn);
        imagingStudy = imagingStudyIn;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected LogicGraph getLogicGraph() {
        throw new UnsupportedOperationException();
    }
}
