package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public abstract class AbstractFhirClassifier implements FhirElementClassifierService {

    final TerminologyStoreDI terminologyStoreDI;

    protected AbstractFhirClassifier(final TerminologyStoreDI terminologyStoreDIIn) {
        terminologyStoreDI = terminologyStoreDIIn;
    }
}
