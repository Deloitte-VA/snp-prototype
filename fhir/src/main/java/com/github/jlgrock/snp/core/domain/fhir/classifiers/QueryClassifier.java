package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.Query;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class QueryClassifier extends AbstractFhirClassifier {

    private final Query query;

    public QueryClassifier(final TerminologyStoreDI terminologyStoreDIIn, final Query queryIn) {
        super(terminologyStoreDIIn);
        query = queryIn;
    }

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
