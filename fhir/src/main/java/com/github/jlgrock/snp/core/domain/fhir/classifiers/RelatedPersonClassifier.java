package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.RelatedPerson;

/**
 *
 */
public class RelatedPersonClassifier extends AbstractFhirClassifier {

    private final RelatedPerson relatedPerson;

    public RelatedPersonClassifier(final RelatedPerson relatedPersonIn) {
        relatedPerson = relatedPersonIn;
    }

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
