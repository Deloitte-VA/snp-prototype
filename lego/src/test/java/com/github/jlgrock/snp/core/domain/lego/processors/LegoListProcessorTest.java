package com.github.jlgrock.snp.core.domain.lego.processors;

import com.github.jlgrock.snp.domain.types.ClassifiedPce;
import org.mockito.Mockito;
import org.testng.annotations.Test;

/**
 *
 */
public class LegoListProcessorTest extends AbstractProcessorTest {

    @Test
    public void testLegoListProcessor() {
        LegoElementProcessorService legoElementProcessorService =
                new LegoListProcessor(logicGraphClassifier, classifiedPceRepository, legoLogicalExpressionBuilder);
        legoElementProcessorService.process(legoList);
        Mockito.verify(classifiedPceRepository).save(Mockito.any(ClassifiedPce.class));
    }
}
