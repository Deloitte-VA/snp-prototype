package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.Query;

/**
 *
 */
public class QueryClassifier extends AbstractFhirClassifier {

    private final Query query;

    public QueryClassifier(final Query queryIn) {
        query = queryIn;
    }

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
