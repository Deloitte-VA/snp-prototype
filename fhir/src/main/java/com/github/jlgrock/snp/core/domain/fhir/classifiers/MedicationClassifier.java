package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.Medication;
import gov.vha.isaac.logic.LogicGraph;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class MedicationClassifier extends AbstractFhirClassifier {

    private final Medication medication;

    public MedicationClassifier(final TerminologyStoreDI terminologyStoreDIIn, final Medication medicationIn) {
        super(terminologyStoreDIIn);
        medication = medicationIn;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected LogicGraph getLogicGraph() {
        throw new UnsupportedOperationException();
    }
}
