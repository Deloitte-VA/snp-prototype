package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.core.domain.fhir.model.MedicationAdministration;
import gov.vha.isaac.logic.LogicGraph;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class MedicationAdministractionProcessor extends AbstractFhirProcessor {

    private final MedicationAdministration medicationAdministration;

    public MedicationAdministractionProcessor(final TerminologyStoreDI terminologyStoreDIIn, final MedicationAdministration medicationAdministrationIn) {
        super(terminologyStoreDIIn);
        medicationAdministration = medicationAdministrationIn;
    }

    @Override
    protected LogicGraph getLogicGraph() {
        throw new UnsupportedOperationException();
    }
}
