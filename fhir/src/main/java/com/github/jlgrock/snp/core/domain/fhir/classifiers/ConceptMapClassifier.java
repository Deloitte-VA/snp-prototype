package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.ConceptMap;

/**
 *
 */
public class ConceptMapClassifier extends AbstractFhirClassifier {

    private final ConceptMap conceptMap;

    public ConceptMapClassifier(final ConceptMap conceptMapIn) {
        conceptMap = conceptMapIn;
    }

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
