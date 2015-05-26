package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.ImagingStudy;
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

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
