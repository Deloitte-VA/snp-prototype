package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.core.domain.fhir.model.Patient;
import gov.vha.isaac.logic.LogicGraph;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class PatientProcessor extends AbstractFhirProcessor {

    private final Patient patient;

    public PatientProcessor(final TerminologyStoreDI terminologyStoreDIIn, final Patient patientIn) {
        super(terminologyStoreDIIn);
        patient = patientIn;
    }

    @Override
    protected LogicGraph getLogicGraph() {
        throw new UnsupportedOperationException();
    }
}
