package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.model.Specimen;
import gov.vha.isaac.logic.LogicGraph;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class SpecimenClassifier extends AbstractFhirClassifier {

    private final Specimen specimen;

    public SpecimenClassifier(final TerminologyStoreDI terminologyStoreDIIn, final Specimen specimenIn) {
        super(terminologyStoreDIIn);
        specimen = specimenIn;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected LogicGraph getLogicGraph() {
        throw new UnsupportedOperationException();
    }
}
