package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.RelatedPerson;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class RelatedPersonClassifier extends AbstractFhirClassifier {

    private final RelatedPerson relatedPerson;

    public RelatedPersonClassifier(final TerminologyStoreDI terminologyStoreDIIn, final RelatedPerson relatedPersonIn) {
        super(terminologyStoreDIIn);
        relatedPerson = relatedPersonIn;
    }

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
