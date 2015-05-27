package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.model.Group;
import gov.vha.isaac.logic.LogicGraph;
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

    /**
     * {@inheritDoc}
     */
    @Override
    protected LogicGraph getLogicGraph() {
        throw new UnsupportedOperationException();
    }
}
