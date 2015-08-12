package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.domain.types.ClassifiedPce;
import com.github.jlgrock.snp.domain.types.Encounter;
import org.mockito.Mockito;
import org.testng.annotations.Test;

/**
 *
 */
public class ObservationProcessorTest extends AbstractProcessorTest {
    @Test
    public void testObservation() {
        FhirElementProcessorService fhirElementProcessorService =
                new ObservationProcessor(logicalExpressionClassifier, fhirCodeableConceptGraphBuilder,
                        classifiedPceRepository, encounterRepository);
        fhirElementProcessorService.process("id", observation);

        Mockito.verify(classifiedPceRepository, Mockito.times(3)).save(Mockito.any(ClassifiedPce.class));
        Mockito.verify(encounterRepository).save(Mockito.any(Encounter.class));
    }
}
