package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.model.Patient;
import gov.vha.isaac.logic.LogicGraph;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class PatientClassifier extends AbstractFhirClassifier {

    private final Patient patient;

    public PatientClassifier(final TerminologyStoreDI terminologyStoreDIIn, final Patient patientIn) {
        super(terminologyStoreDIIn);
        patient = patientIn;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected LogicGraph getLogicGraph() {
        throw new UnsupportedOperationException();
    }
}
