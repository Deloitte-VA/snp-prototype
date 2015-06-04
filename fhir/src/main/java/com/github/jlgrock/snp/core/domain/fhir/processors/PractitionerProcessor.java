package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.core.domain.fhir.model.Practitioner;
import gov.vha.isaac.logic.LogicGraph;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class PractitionerProcessor extends AbstractFhirProcessor {

    private final Practitioner practitioner;

    public PractitionerProcessor(final TerminologyStoreDI terminologyStoreDIIn, final Practitioner practitionerIn) {
        super(terminologyStoreDIIn);
        practitioner = practitionerIn;
    }

    @Override
    protected LogicGraph getLogicGraph() {
        throw new UnsupportedOperationException();
    }
}
