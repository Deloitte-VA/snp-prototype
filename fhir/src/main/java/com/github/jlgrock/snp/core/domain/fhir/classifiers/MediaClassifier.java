package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.Media;
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

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
