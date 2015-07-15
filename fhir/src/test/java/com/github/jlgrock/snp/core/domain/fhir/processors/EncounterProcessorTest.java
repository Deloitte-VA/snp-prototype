package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.domain.types.ClassifiedPce;
import org.mockito.Mockito;
import org.testng.annotations.Test;

/**
 *
 */
public class EncounterProcessorTest extends AbstractProcessorTest {
    @Test
    public void testEncounter() {
        FhirElementProcessorService fhirElementProcessorService =
                new EncounterProcessor(logicGraphClassifier, fhirEncounterConverter, encounterRepository, patientRepository);
        fhirElementProcessorService.process("id", encounter);

        Mockito.verify(encounterRepository).save(encounterDomain);
        Mockito.verify(classifiedPceRepository).save(Mockito.any(ClassifiedPce.class));
    }
}
