package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.List;

/**
 *
 */
public class ListClassifier extends AbstractFhirClassifier {

    private final List list;

    public ListClassifier(final List listIn) {
        list = listIn;
    }

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
