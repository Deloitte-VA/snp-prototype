package com.github.jlgrock.snp.core.domain.lego.logicgraph;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.lego.model.Expression;
import org.mockito.Mockito;
import org.testng.annotations.Test;

/**
 *
 */
public class LegoExpressionGraphBuilderTest {

    final LogicGraphClassifier logicGraphClassifier = Mockito.mock(LogicGraphClassifier.class);

    final Expression expression = Mockito.mock(Expression.class);

    @Test
    void testBuild() {

        LegoExpressionGraphBuilder legoExpressionGraphBuilder =
                new LegoExpressionGraphBuilder(logicGraphClassifier, expression);
        legoExpressionGraphBuilder.build();
    }
}
