package com.github.jlgrock.snp.core.domain.lego.processors;

import com.github.jlgrock.snp.domain.types.ClassifiedPce;
import org.mockito.Mockito;
import org.testng.annotations.Test;

/**
 *
 */
public class LegoProcessorTest extends AbstractProcessorTest {

    @Test
    public void testLegoProcessor() {
        LegoElementProcessorService legoElementProcessorService =
                new LegoProcessor(logicGraphClassifier, legoExpressionGraphBuilder, classifiedPceRepository);
        legoElementProcessorService.process(lego);
        Mockito.verify(classifiedPceRepository).save(Mockito.any(ClassifiedPce.class));
    }
}
