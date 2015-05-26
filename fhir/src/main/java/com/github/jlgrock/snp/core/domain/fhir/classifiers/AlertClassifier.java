package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.Alert;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class AlertClassifier extends AbstractFhirClassifier {

    private final Alert alert;

    public AlertClassifier(final TerminologyStoreDI terminologyStoreDIIn, final Alert alertIn) {
        super(terminologyStoreDIIn);
        alert = alertIn;
    }

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
