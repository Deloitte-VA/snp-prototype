package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.Group;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class GroupClassifier extends AbstractFhirClassifier {

    private final Group group;

    public GroupClassifier(final TerminologyStoreDI terminologyStoreDIIn, final Group groupIn) {
        super(terminologyStoreDIIn);
        group = groupIn;
    }

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
