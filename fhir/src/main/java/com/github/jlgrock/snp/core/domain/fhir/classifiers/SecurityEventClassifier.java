package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.SecurityEvent;

/**
 *
 */
public class SecurityEventClassifier extends AbstractFhirClassifier {

    private final SecurityEvent securityEvent;

    public SecurityEventClassifier(final SecurityEvent securityEventIn) {
        securityEvent = securityEventIn;
    }

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
