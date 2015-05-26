package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.Immunization;
import gov.vha.isaac.logic.LogicGraph;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class ImmunizationClassifier extends AbstractFhirClassifier {

    private final Immunization immunization;

    public ImmunizationClassifier(final TerminologyStoreDI terminologyStoreDIIn, final Immunization immunizationIn) {
        super(terminologyStoreDIIn);
        immunization = immunizationIn;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected LogicGraph getLogicGraph() {
        throw new UnsupportedOperationException();
    }
}
