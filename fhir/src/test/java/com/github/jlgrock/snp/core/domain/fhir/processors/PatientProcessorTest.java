package com.github.jlgrock.snp.core.domain.fhir.processors;

import org.mockito.Mockito;
import org.testng.annotations.Test;

/**
 *
 */
public class PatientProcessorTest extends AbstractProcessorTest {
    @Test
    public void testPatient() {
        FhirElementProcessorService fhirElementProcessorService =
                new PatientProcessor(logicalExpressionClassifier, fhirPatientConverter, patientRepository);
        fhirElementProcessorService.process("id", patient);

        Mockito.verify(patientRepository).save(patientDomain);
    }
}
