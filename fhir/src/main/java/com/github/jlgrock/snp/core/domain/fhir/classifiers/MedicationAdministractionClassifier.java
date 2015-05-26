package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.MedicationAdministration;
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

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
