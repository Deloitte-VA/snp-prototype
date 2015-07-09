package com.github.jlgrock.snp.core.domain.lego.logicgraph;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.lego.AbstractClassificationTest;
import com.github.jlgrock.snp.core.domain.lego.model.Concept;
import com.github.jlgrock.snp.core.domain.lego.model.Expression;
import gov.vha.isaac.logic.LogicGraph;
import gov.vha.isaac.ochre.api.logic.LogicalExpressionBuilder;
import gov.vha.isaac.ochre.api.logic.assertions.connectors.Connector;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class LogicExpressionBuilderTest extends AbstractClassificationTest {
    private LogicGraphClassifier logicGraphClassifier = Mockito.mock(LogicGraphClassifier.class);

    // expression Can have either a Concept or a list of sub-Expressions, plus 0 or more Relations and 0 or more RelationGroups
    // A relation can have a type (which contains one single concept) and a destination
    // Type can only take a concept.  Since this is only used in Relations (currently), this returns a ConceptSpec.
    // A destination can contain an expression, text, boolean, or measurement
    // concept - A Concept can have a uuid, an sctid, and a description.  These will be turned into the corresponding Conceptspec

    @Test
    public void testLegoGraphConnector() throws Exception {
        Expression expression = Mockito.mock(Expression.class);
        Concept concept = Mockito.mock(Concept.class);
        Mockito.when(expression.getConcept()).thenReturn(concept);
        Mockito.when(concept.getSctid()).thenReturn(123l);

        LegoExpressionGraphBuilder legoExpressionGraphBuilder
                = new LegoExpressionGraphBuilder(logicGraphClassifier);
        LogicGraph logicGraph = legoExpressionGraphBuilder.build(expression);
        Assert.assertEquals(logicGraph, LogicalExpressionBuilder.SufficientSet((Connector) expression));
    }

    @Test
    public void testLegoGraphNonConnector() throws Exception {
        Expression expression = Mockito.mock(Expression.class);

        Concept subConcept1 = Mockito.mock(Concept.class);
        Mockito.when(subConcept1.getSctid()).thenReturn(444l);
        Expression subexpression1 = Mockito.mock(Expression.class);
        Mockito.when(subexpression1.getConcept()).thenReturn(subConcept1);

        Concept subConcept2 = Mockito.mock(Concept.class);
        Mockito.when(subConcept2.getSctid()).thenReturn(333l);
        Expression subexpression2 = Mockito.mock(Expression.class);
        Mockito.when(subexpression2.getConcept()).thenReturn(subConcept2);

        List<Expression> subexpressions = new ArrayList<>();
        subexpressions.add(subexpression1);
        subexpressions.add(subexpression2);

        Mockito.when(expression.getExpression());

        LegoExpressionGraphBuilder legoExpressionGraphBuilder
                = new LegoExpressionGraphBuilder(logicGraphClassifier);
        LogicGraph logicGraph = legoExpressionGraphBuilder.build(expression);

//        SufficientSet expected = LogicalExpressionBuilder.SufficientSet(
//                LogicalExpressionBuilder.And(LogicalExpressionBuilder.And());
//
//        Assert.assertEquals(logicGraph, expected);
    }
}
