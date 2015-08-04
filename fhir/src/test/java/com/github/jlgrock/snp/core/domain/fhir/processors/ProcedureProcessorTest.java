package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.domain.types.ClassifiedPce;
import com.github.jlgrock.snp.domain.types.Encounter;
import org.mockito.Mockito;
import org.testng.annotations.Test;

/**
 *
 */
public class ProcedureProcessorTest extends AbstractProcessorTest {
    @Test
    public void testProcedure() {
        FhirElementProcessorService fhirElementProcessorService =
                new ProcedureProcessor(logicalExpressionClassifier, encounterRepository, classifiedPceRepository, fhirCodeableConceptGraphBuilder);
        fhirElementProcessorService.process("id", procedure);

        Mockito.verify(logicalExpressionClassifier).classify(logicalExpression);
        Mockito.verify(encounterRepository).save(Mockito.any(Encounter.class));
        Mockito.verify(classifiedPceRepository).save(Mockito.any(ClassifiedPce.class));
    }
}
