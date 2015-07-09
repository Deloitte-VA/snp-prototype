package com.github.jlgrock.snp.core.domain.lego.processors;

import com.github.jlgrock.snp.domain.types.ClassifiedPce;
import org.mockito.Mockito;
import org.testng.annotations.Test;

/**
 *
 */
public class DiscernibleProcessorTest extends AbstractProcessorTest {

    @Test
    public void testDiscernable() {
        LegoElementProcessorService legoElementProcessorService =
                new DiscernibleProcessor(logicGraphClassifier, legoExpressionGraphBuilder, classifiedPceRepository);
        legoElementProcessorService.process(discernible);
        Mockito.verify(classifiedPceRepository).save(Mockito.any(ClassifiedPce.class));
    }

}
