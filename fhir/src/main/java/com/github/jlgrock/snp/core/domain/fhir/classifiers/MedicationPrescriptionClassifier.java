package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.MedicationPrescription;
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

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
