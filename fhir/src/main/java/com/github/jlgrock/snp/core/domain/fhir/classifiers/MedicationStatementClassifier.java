package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.MedicationStatement;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class MedicationStatementClassifier extends AbstractFhirClassifier {

    private final MedicationStatement medicationStatement;

    public MedicationStatementClassifier(final TerminologyStoreDI terminologyStoreDIIn, final MedicationStatement medicationStatementIn) {
        super(terminologyStoreDIIn);
        medicationStatement = medicationStatementIn;
    }

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
