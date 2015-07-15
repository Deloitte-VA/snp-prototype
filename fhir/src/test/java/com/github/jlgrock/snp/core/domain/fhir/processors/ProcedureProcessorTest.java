package com.github.jlgrock.snp.core.domain.fhir.processors;

import org.mockito.Mockito;
import org.testng.annotations.Test;

/**
 *
 */
public class ProcedureProcessorTest extends AbstractProcessorTest {
    @Test
    public void testProcedure() {
        FhirElementProcessorService fhirElementProcessorService =
                new ProcedureProcessor(logicGraphClassifier, encounterRepository, classifiedPceRepository, fhirCodeableConceptGraphBuilder);
        fhirElementProcessorService.process("id", procedure);

        Mockito.verify(logicGraphClassifier).classify(logicGraph);
        Mockito.verify(encounterRepository).save(encounterDomain);
        Mockito.verify(classifiedPceRepository).save(classifiedPce);
    }
}
