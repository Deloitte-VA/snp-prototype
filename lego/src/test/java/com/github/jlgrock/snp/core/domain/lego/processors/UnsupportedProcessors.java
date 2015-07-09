package com.github.jlgrock.snp.core.domain.lego.processors;

import com.github.jlgrock.snp.core.domain.lego.model.AssertionComponent;
import com.github.jlgrock.snp.core.domain.lego.model.Interval;
import com.github.jlgrock.snp.core.domain.lego.model.Pncs;
import com.github.jlgrock.snp.core.domain.lego.model.Qualifier;
import com.github.jlgrock.snp.core.domain.lego.model.Relation;
import com.github.jlgrock.snp.core.domain.lego.model.RelationGroup;
import com.github.jlgrock.snp.core.domain.lego.model.Stamp;
import com.github.jlgrock.snp.core.domain.lego.model.Type;
import com.github.jlgrock.snp.core.domain.lego.model.Units;
import com.github.jlgrock.snp.core.domain.lego.model.Value;
import org.mockito.Mockito;
import org.testng.annotations.Test;

/**
 *
 */
public class UnsupportedProcessors extends AbstractProcessorTest {

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testAssertionComponent() {
        AssertionComponent assertionComponent = Mockito.mock(AssertionComponent.class);
        LegoElementProcessorService legoElementProcessorService =
                new AssertionComponentProcessor(logicGraphClassifier, legoExpressionGraphBuilder, classifiedPceRepository);
        legoElementProcessorService.process(assertionComponent);
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testInterval() {
        Interval interval = Mockito.mock(Interval.class);
        LegoElementProcessorService legoElementProcessorService =
                new IntervalProcessor(logicGraphClassifier, legoExpressionGraphBuilder, classifiedPceRepository);
        legoElementProcessorService.process(interval);
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testPncs() {
        Pncs pncs = Mockito.mock(Pncs.class);
        LegoElementProcessorService legoElementProcessorService =
                new PncsProcessor(logicGraphClassifier, legoExpressionGraphBuilder, classifiedPceRepository);
        legoElementProcessorService.process(pncs);
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testQualifier() {
        Qualifier qualifier = Mockito.mock(Qualifier.class);
        LegoElementProcessorService legoElementProcessorService =
                new QualifierProcessor(logicGraphClassifier, legoExpressionGraphBuilder, classifiedPceRepository);
        legoElementProcessorService.process(qualifier);
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testRelationGroup() {
        RelationGroup relationGroup = Mockito.mock(RelationGroup.class);
        LegoElementProcessorService legoElementProcessorService =
                new RelationGroupProcessor(logicGraphClassifier, legoExpressionGraphBuilder, classifiedPceRepository);
        legoElementProcessorService.process(relationGroup);
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testRelation() {
        Relation relation = Mockito.mock(Relation.class);
        LegoElementProcessorService legoElementProcessorService =
                new RelationProcessor(logicGraphClassifier, legoExpressionGraphBuilder, classifiedPceRepository);
        legoElementProcessorService.process(relation);
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testStamp() {
        Stamp stamp = Mockito.mock(Stamp.class);
        LegoElementProcessorService legoElementProcessorService =
                new StampProcessor(logicGraphClassifier, legoExpressionGraphBuilder, classifiedPceRepository);
        legoElementProcessorService.process(stamp);
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testType() {
        Type type = Mockito.mock(Type.class);
        LegoElementProcessorService legoElementProcessorService =
                new TypeProcessor(logicGraphClassifier, legoExpressionGraphBuilder, classifiedPceRepository);
        legoElementProcessorService.process(type);
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testUnits() {
        Units units = Mockito.mock(Units.class);
        LegoElementProcessorService legoElementProcessorService =
                new UnitsProcessor(logicGraphClassifier, legoExpressionGraphBuilder, classifiedPceRepository);
        legoElementProcessorService.process(units);
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testValue() {
        Value value = Mockito.mock(Value.class);
        LegoElementProcessorService legoElementProcessorService =
                new ValueProcessor(logicGraphClassifier, legoExpressionGraphBuilder, classifiedPceRepository);
        legoElementProcessorService.process(value);
    }
}
