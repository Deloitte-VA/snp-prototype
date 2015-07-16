package com.github.jlgrock.snp.core.domain.lego.processors;

import com.github.jlgrock.snp.domain.types.ClassifiedPce;
import org.mockito.Mockito;
import org.testng.annotations.Test;

/**
 *
 */
public class AssertionProcessorTest extends AbstractProcessorTest {

    @Test
    public void testAssertion() {
        LegoElementProcessorService legoElementProcessorService =
                new AssertionProcessor(logicGraphClassifier, legoExpressionGraphBuilder, classifiedPceRepository);
        legoElementProcessorService.process(assertion);
        Mockito.verify(classifiedPceRepository).save(Mockito.any(ClassifiedPce.class));
    }


}
