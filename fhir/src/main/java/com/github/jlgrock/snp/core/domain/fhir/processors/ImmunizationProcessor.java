package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.core.domain.fhir.model.Immunization;
import gov.vha.isaac.logic.LogicGraph;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class ImmunizationProcessor extends AbstractFhirProcessor {

    private final Immunization immunization;

    public ImmunizationProcessor(final TerminologyStoreDI terminologyStoreDIIn, final Immunization immunizationIn) {
        super(terminologyStoreDIIn);
        immunization = immunizationIn;
    }

    @Override
    protected LogicGraph getLogicGraph() {
        throw new UnsupportedOperationException();
    }
}
