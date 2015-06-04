package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.core.domain.fhir.model.Specimen;
import gov.vha.isaac.logic.LogicGraph;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class SpecimenProcessor extends AbstractFhirProcessor {

    private final Specimen specimen;

    public SpecimenProcessor(final TerminologyStoreDI terminologyStoreDIIn, final Specimen specimenIn) {
        super(terminologyStoreDIIn);
        specimen = specimenIn;
    }

    @Override
    protected LogicGraph getLogicGraph() {
        throw new UnsupportedOperationException();
    }
}
