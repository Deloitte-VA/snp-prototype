package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.model.Profile;
import gov.vha.isaac.logic.LogicGraph;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class ProfileClassifier extends AbstractFhirClassifier {

    private final Profile profile;

    public ProfileClassifier(final TerminologyStoreDI terminologyStoreDIIn, final Profile profileIn) {
        super(terminologyStoreDIIn);
        profile = profileIn;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected LogicGraph getLogicGraph() {
        throw new UnsupportedOperationException();
    }
}
