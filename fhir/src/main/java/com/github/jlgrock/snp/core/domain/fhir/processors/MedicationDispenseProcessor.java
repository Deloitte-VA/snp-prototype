package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.core.domain.fhir.model.MedicationDispense;
import gov.vha.isaac.logic.LogicGraph;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class MedicationDispenseProcessor extends AbstractFhirProcessor {

    private final MedicationDispense medicationDispense;

    public MedicationDispenseProcessor(final TerminologyStoreDI terminologyStoreDIIn, final MedicationDispense medicationDispenseIn) {
        super(terminologyStoreDIIn);
        medicationDispense = medicationDispenseIn;
    }

    @Override
    protected LogicGraph getLogicGraph() {
        throw new UnsupportedOperationException();
    }
}
