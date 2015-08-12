package com.github.jlgrock.snp.core.domain.lego.logicgraph;

import com.github.jlgrock.snp.apis.classifier.LogicalExpressionClassifier;
import com.github.jlgrock.snp.core.domain.lego.model.Expression;
import org.mockito.Mockito;
import org.testng.annotations.Test;

/**
 *
 */
public class LegoExpressionGraphBuilderTest {

    final LogicalExpressionClassifier logicalExpressionClassifier = Mockito.mock(LogicalExpressionClassifier.class);

    final Expression expression = Mockito.mock(Expression.class);

    @Test
    void testBuild() {

//        LegoExpressionGraphBuilder legoExpressionGraphBuilder =
//                new LegoExpressionGraphBuilder(logicGraphClassifier, expression);
//        legoExpressionGraphBuilder.build();
    }
}
