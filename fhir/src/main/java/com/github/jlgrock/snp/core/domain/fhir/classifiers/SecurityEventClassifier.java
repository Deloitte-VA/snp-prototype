package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.SecurityEvent;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class SecurityEventClassifier extends AbstractFhirClassifier {

    private final SecurityEvent securityEvent;

    public SecurityEventClassifier(final TerminologyStoreDI terminologyStoreDIIn, final SecurityEvent securityEventIn) {
        super(terminologyStoreDIIn);
        securityEvent = securityEventIn;
    }

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
