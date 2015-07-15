package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.domain.types.ClassifiedPce;
import com.github.jlgrock.snp.domain.types.Encounter;
import org.mockito.Mockito;
import org.testng.annotations.Test;

/**
 *
 */
public class ConditionProcessorTest extends AbstractProcessorTest {
    @Test
    public void testCondition() {
        FhirElementProcessorService fhirElementProcessorService =
                new ConditionProcessor(logicGraphClassifier, encounterRepository,
                        classifiedPceRepository, fhirCodeableConceptGraphBuilder);
        fhirElementProcessorService.process("id", condition);

        Mockito.verify(logicGraphClassifier).classify(logicGraph);
        Mockito.verify(encounterRepository).save(Mockito.any(Encounter.class));
        Mockito.verify(classifiedPceRepository).save(Mockito.any(ClassifiedPce.class));
    }
}
