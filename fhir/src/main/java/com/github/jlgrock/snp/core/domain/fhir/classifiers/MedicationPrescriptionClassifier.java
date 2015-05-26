package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.MedicationPrescription;
import gov.vha.isaac.logic.LogicGraph;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class MedicationPrescriptionClassifier extends AbstractFhirClassifier {

    private final MedicationPrescription medicationPrescription;

    public MedicationPrescriptionClassifier(final TerminologyStoreDI terminologyStoreDIIn, final MedicationPrescription medicationPrescriptionIn) {
        super(terminologyStoreDIIn);
        medicationPrescription = medicationPrescriptionIn;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected LogicGraph getLogicGraph() {
        throw new UnsupportedOperationException();
    }
}
