package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.MedicationDispense;
import gov.vha.isaac.logic.LogicGraph;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class MedicationDispenseClassifier extends AbstractFhirClassifier {

    private final MedicationDispense medicationDispense;

    public MedicationDispenseClassifier(final TerminologyStoreDI terminologyStoreDIIn, final MedicationDispense medicationDispenseIn) {
        super(terminologyStoreDIIn);
        medicationDispense = medicationDispenseIn;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected LogicGraph getLogicGraph() {
        throw new UnsupportedOperationException();
    }
}
