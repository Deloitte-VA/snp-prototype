package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.ImagingStudy;

/**
 *
 */
public class ImagingStudyClassifier extends AbstractFhirClassifier {

    private final ImagingStudy imagingStudy;

    public ImagingStudyClassifier(final ImagingStudy imagingStudyIn) {
        imagingStudy = imagingStudyIn;
    }

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
