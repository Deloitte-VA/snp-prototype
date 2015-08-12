package com.github.jlgrock.snp.core.domain.fhir.processors;

import org.mockito.Mockito;
import org.testng.annotations.Test;

/**
 *
 */
public class EncounterProcessorTest extends AbstractProcessorTest {
    @Test
    public void testEncounter() {
        FhirElementProcessorService fhirElementProcessorService =
                new EncounterProcessor(logicalExpressionClassifier, fhirEncounterConverter, encounterRepository, patientRepository);
        fhirElementProcessorService.process("id", encounter);

        Mockito.verify(encounterRepository).save(encounterDomain);
    }
}
