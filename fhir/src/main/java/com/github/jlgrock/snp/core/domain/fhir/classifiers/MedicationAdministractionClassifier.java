package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.model.MedicationAdministration;
import gov.vha.isaac.logic.LogicGraph;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class MedicationAdministractionClassifier extends AbstractFhirClassifier {

    private final MedicationAdministration medicationAdministration;

    public MedicationAdministractionClassifier(final TerminologyStoreDI terminologyStoreDIIn, final MedicationAdministration medicationAdministrationIn) {
        super(terminologyStoreDIIn);
        medicationAdministration = medicationAdministrationIn;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected LogicGraph getLogicGraph() {
        throw new UnsupportedOperationException();
    }
}
