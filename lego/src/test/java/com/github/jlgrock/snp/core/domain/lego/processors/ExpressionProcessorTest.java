package com.github.jlgrock.snp.core.domain.lego.processors;

import com.github.jlgrock.snp.domain.types.ClassifiedPce;
import org.mockito.Mockito;
import org.testng.annotations.Test;

/**
 *
 */
public class ExpressionProcessorTest extends AbstractProcessorTest {

    @Test
    public void testExpression() {
        LegoElementProcessorService legoElementProcessorService =
                new ExpressionProcessor(logicGraphClassifier, classifiedPceRepository, legoLogicalExpressionBuilder);
        legoElementProcessorService.process(expression);
        Mockito.verify(classifiedPceRepository).save(Mockito.any(ClassifiedPce.class));
    }


}
