package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.Group;

/**
 *
 */
public class GroupClassifier extends AbstractFhirClassifier {

    private final Group group;

    public GroupClassifier(final Group groupIn) {
        group = groupIn;
    }

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
