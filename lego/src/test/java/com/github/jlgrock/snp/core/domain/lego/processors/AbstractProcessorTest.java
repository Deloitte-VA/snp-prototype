package com.github.jlgrock.snp.core.domain.lego.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.lego.logicgraph.LegoExpressionGraphBuilder;
import com.github.jlgrock.snp.core.domain.lego.model.Assertion;
import com.github.jlgrock.snp.core.domain.lego.model.Concept;
import com.github.jlgrock.snp.core.domain.lego.model.Discernible;
import com.github.jlgrock.snp.core.domain.lego.model.Expression;
import com.github.jlgrock.snp.core.domain.lego.model.Lego;
import com.github.jlgrock.snp.core.domain.lego.model.LegoList;
import com.github.jlgrock.snp.core.domain.lego.model.Relation;
import com.github.jlgrock.snp.core.domain.lego.model.RelationGroup;
import com.github.jlgrock.snp.domain.data.ClassifiedPceRepository;
import gov.vha.isaac.logic.LogicGraph;
import org.mockito.Mockito;
import org.testng.annotations.BeforeClass;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class AbstractProcessorTest {

    protected LogicGraphClassifier logicGraphClassifier = Mockito.mock(LogicGraphClassifier.class);
    protected ClassifiedPceRepository classifiedPceRepository = Mockito.mock(ClassifiedPceRepository.class);
    protected LegoExpressionGraphBuilder legoExpressionGraphBuilder = Mockito.mock(LegoExpressionGraphBuilder.class);

    protected Assertion assertion = Mockito.mock(Assertion.class);
    protected Assertion assertion2 = Mockito.mock(Assertion.class);
    protected List<Assertion> assertions;
    protected Discernible discernible = Mockito.mock(Discernible.class);
    protected Expression expression = Mockito.mock(Expression.class);
    protected Expression expression2 = Mockito.mock(Expression.class);
    protected Lego lego = Mockito.mock(Lego.class);
    protected Lego lego2 = Mockito.mock(Lego.class);
    protected List<Lego> legos;
    protected LegoList legoList = Mockito.mock(LegoList.class);
    protected Concept concept = Mockito.mock(Concept.class);
    protected Relation relation = Mockito.mock(Relation.class);
    protected Relation relation2 = Mockito.mock(Relation.class);
    protected List<Relation> relations;
    protected RelationGroup relationGroup = Mockito.mock(RelationGroup.class);
    protected RelationGroup relationGroup2 = Mockito.mock(RelationGroup.class);
    protected List<RelationGroup> relationGroups;

    protected LogicGraph logicGraph = Mockito.mock(LogicGraph.class);

    @BeforeClass
    public void setup() {
        Mockito.when(legoExpressionGraphBuilder.build(expression)).thenReturn(logicGraph);

        legos = new ArrayList<>();
        legos.add(lego);
        legos.add(lego2);

        assertions = new ArrayList<>();
        assertions.add(assertion);
        assertions.add(assertion2);

        relations = new ArrayList<>();
        relations.add(relation);
        relations.add(relation2);

        relationGroups = new ArrayList<>();
        relationGroups.add(relationGroup);
        relationGroups.add(relationGroup2);

        Mockito.when(legoList.getLego()).thenReturn(legos);

        Mockito.when(lego.getAssertion()).thenReturn(assertions);

        Mockito.when(assertion.getDiscernible()).thenReturn(discernible);
        Mockito.when(discernible.getExpression()).thenReturn(expression);

        Mockito.when(expression.getConcept()).thenReturn(concept);
        Mockito.when(expression.getRelation()).thenReturn(relations);

        Mockito.when(expression2.getConcept()).thenReturn(concept);
        Mockito.when(expression2.getRelationGroup()).thenReturn(relationGroups);

        Mockito.when(logicGraphClassifier.classify(logicGraph)).thenReturn(1);
        Mockito.when(legoExpressionGraphBuilder.build(expression)).thenReturn(logicGraph);
    }
}
