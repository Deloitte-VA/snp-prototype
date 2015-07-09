package com.github.jlgrock.snp.core.domain.lego.processors;

import com.github.jlgrock.snp.apis.exceptions.ClassifierException;
import com.github.jlgrock.snp.core.domain.lego.model.Assertion;
import com.github.jlgrock.snp.core.domain.lego.model.AssertionComponent;
import com.github.jlgrock.snp.core.domain.lego.model.Concept;
import com.github.jlgrock.snp.core.domain.lego.model.Destination;
import com.github.jlgrock.snp.core.domain.lego.model.Discernible;
import com.github.jlgrock.snp.core.domain.lego.model.Expression;
import com.github.jlgrock.snp.core.domain.lego.model.Interval;
import com.github.jlgrock.snp.core.domain.lego.model.Lego;
import com.github.jlgrock.snp.core.domain.lego.model.LegoList;
import com.github.jlgrock.snp.core.domain.lego.model.Pncs;
import com.github.jlgrock.snp.core.domain.lego.model.Qualifier;
import com.github.jlgrock.snp.core.domain.lego.model.Relation;
import com.github.jlgrock.snp.core.domain.lego.model.RelationGroup;
import com.github.jlgrock.snp.core.domain.lego.model.Stamp;
import com.github.jlgrock.snp.core.domain.lego.model.Type;
import com.github.jlgrock.snp.core.domain.lego.model.Units;
import com.github.jlgrock.snp.core.domain.lego.model.Value;
import org.glassfish.hk2.api.IterableProvider;
import org.glassfish.hk2.api.ServiceHandle;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 *
 */
public class LegoElementProcessorFactoryImplTest {

    AssertionComponent assertionComponent = new AssertionComponent();
    AssertionComponentProcessor assertionComponentProcessor = Mockito.mock(AssertionComponentProcessor.class);
    Assertion assertion = new Assertion();
    AssertionProcessor assertionProcessor = Mockito.mock(AssertionProcessor.class);
    Concept concept = new Concept();
    ConceptProcessor conceptProcessor = Mockito.mock(ConceptProcessor.class);
    Destination destination = new Destination();
    DestinationProcessor destinationProcessor = Mockito.mock(DestinationProcessor.class);
    Discernible discernible = new Discernible();
    DiscernibleProcessor discernibleProcessor = Mockito.mock(DiscernibleProcessor.class);
    Expression expression = new Expression();
    ExpressionProcessor expressionProcessor = Mockito.mock(ExpressionProcessor.class);
    Interval interval = new Interval();
    IntervalProcessor intervalProcessor = Mockito.mock(IntervalProcessor.class);
    LegoList legoList = new LegoList();
    LegoListProcessor legoListProcessor = Mockito.mock(LegoListProcessor.class);
    Lego lego = new Lego();
    LegoProcessor legoProcessor = Mockito.mock(LegoProcessor.class);
    Pncs pncs = new Pncs();
    PncsProcessor pncsProcessor = Mockito.mock(PncsProcessor.class);
    Qualifier qualifier = new Qualifier();
    QualifierProcessor qualifierProcessor = Mockito.mock(QualifierProcessor.class);
    RelationGroup relationGroup = new RelationGroup();
    RelationGroupProcessor relationGroupProcessor = Mockito.mock(RelationGroupProcessor.class);
    Relation relation = new Relation();
    RelationProcessor relationProcessor = Mockito.mock(RelationProcessor.class);
    Stamp stamp = new Stamp();
    StampProcessor stampProcessor = Mockito.mock(StampProcessor.class);
    Type type = new Type();
    TypeProcessor typeProcessor = Mockito.mock(TypeProcessor.class);
    Units units = new Units();
    UnitsProcessor unitsProcessor = Mockito.mock(UnitsProcessor.class);
    Value value = new Value();
    ValueProcessor valueProcessor = Mockito.mock(ValueProcessor.class);

    Collection<LegoElementProcessorService> processorCollection;
    @BeforeClass
    void setup() {
        Mockito.when(assertionComponentProcessor.processesType()).thenReturn(AssertionComponent.class);
        Mockito.when(assertionProcessor.processesType()).thenReturn(Assertion.class);
        Mockito.when(conceptProcessor.processesType()).thenReturn(Concept.class);
        Mockito.when(destinationProcessor.processesType()).thenReturn(Destination.class);
        Mockito.when(discernibleProcessor.processesType()).thenReturn(Discernible.class);
        Mockito.when(expressionProcessor.processesType()).thenReturn(Expression.class);
        Mockito.when(intervalProcessor.processesType()).thenReturn(Interval.class);
        Mockito.when(legoListProcessor.processesType()).thenReturn(LegoList.class);
        Mockito.when(legoProcessor.processesType()).thenReturn(Lego.class);
        Mockito.when(pncsProcessor.processesType()).thenReturn(Pncs.class);
        Mockito.when(qualifierProcessor.processesType()).thenReturn(Qualifier.class);
        Mockito.when(relationGroupProcessor.processesType()).thenReturn(RelationGroup.class);
        Mockito.when(relationProcessor.processesType()).thenReturn(Relation.class);
        Mockito.when(stampProcessor.processesType()).thenReturn(Stamp.class);
        Mockito.when(typeProcessor.processesType()).thenReturn(Type.class);
        Mockito.when(unitsProcessor.processesType()).thenReturn(Units.class);
        Mockito.when(valueProcessor.processesType()).thenReturn(Value.class);

        processorCollection = new ArrayList<>();
        processorCollection.add(assertionComponentProcessor);
        processorCollection.add(assertionProcessor);
        processorCollection.add(conceptProcessor);
        processorCollection.add(destinationProcessor);
        processorCollection.add(discernibleProcessor);
        processorCollection.add(expressionProcessor);
        processorCollection.add(intervalProcessor);
        processorCollection.add(legoListProcessor);
        processorCollection.add(legoProcessor);
        processorCollection.add(pncsProcessor);
        processorCollection.add(qualifierProcessor);
        processorCollection.add(relationGroupProcessor);
        processorCollection.add(relationProcessor);
        processorCollection.add(stampProcessor);
        processorCollection.add(typeProcessor);
        processorCollection.add(unitsProcessor);
        processorCollection.add(valueProcessor);
    }

    class IterableProviderObjectList implements IterableProvider<LegoElementProcessorService> {

        private Collection coll;

        IterableProviderObjectList(final Collection<LegoElementProcessorService> processorCollectionIn) {
            coll = processorCollectionIn;
        }

        @Override
        public LegoElementProcessorService get() {
            throw new UnsupportedOperationException();
        }

        @Override
        public Iterator iterator() {
            return coll.iterator();
        }

        @Override
        public ServiceHandle getHandle() {
            throw new UnsupportedOperationException();
        }

        @Override
        public int getSize() {
            return coll.size();
        }

        @Override
        public IterableProvider named(String s) {
            throw new UnsupportedOperationException();
        }

        @Override
        public IterableProvider qualifiedWith(Annotation... annotations) {
            throw new UnsupportedOperationException();
        }

        @Override
        public Iterable<ServiceHandle<LegoElementProcessorService>> handleIterator() {
            throw new UnsupportedOperationException();
        }

        @Override
        public IterableProvider<?> ofType(java.lang.reflect.Type type) {
            throw new UnsupportedOperationException();
        }
    }

    @Test
    public void factoryTest() throws ClassifierException {
        IterableProvider<LegoElementProcessorService> iterableProvider =
                new IterableProviderObjectList(processorCollection);
        LegoElementProcessorFactory legoElementProcessorFactory =
                new LegoElementProcessorFactoryImpl(iterableProvider);
        Assert.assertEquals(legoElementProcessorFactory.findElementProcessor(assertionComponent), assertionComponentProcessor);
        Assert.assertEquals(legoElementProcessorFactory.findElementProcessor(assertion), assertionProcessor);
        Assert.assertEquals(legoElementProcessorFactory.findElementProcessor(concept), conceptProcessor);
        Assert.assertEquals(legoElementProcessorFactory.findElementProcessor(destination), destinationProcessor);
        Assert.assertEquals(legoElementProcessorFactory.findElementProcessor(discernible), discernibleProcessor);
        Assert.assertEquals(legoElementProcessorFactory.findElementProcessor(expression), expressionProcessor);
        Assert.assertEquals(legoElementProcessorFactory.findElementProcessor(interval), intervalProcessor);
        Assert.assertEquals(legoElementProcessorFactory.findElementProcessor(legoList), legoListProcessor);
        Assert.assertEquals(legoElementProcessorFactory.findElementProcessor(lego), legoProcessor);
        Assert.assertEquals(legoElementProcessorFactory.findElementProcessor(pncs), pncsProcessor);
        Assert.assertEquals(legoElementProcessorFactory.findElementProcessor(qualifier), qualifierProcessor);
        Assert.assertEquals(legoElementProcessorFactory.findElementProcessor(relationGroup), relationGroupProcessor);
        Assert.assertEquals(legoElementProcessorFactory.findElementProcessor(relation), relationProcessor);
        Assert.assertEquals(legoElementProcessorFactory.findElementProcessor(stamp), stampProcessor);
        Assert.assertEquals(legoElementProcessorFactory.findElementProcessor(type), typeProcessor);
        Assert.assertEquals(legoElementProcessorFactory.findElementProcessor(units), unitsProcessor);
        Assert.assertEquals(legoElementProcessorFactory.findElementProcessor(value), valueProcessor);
    }

    @Test(expectedExceptions = ClassifierException.class)
    public void factoryFailureTest() throws ClassifierException {
        IterableProvider<LegoElementProcessorService> iterableProvider =
                new IterableProviderObjectList(processorCollection);
        LegoElementProcessorFactory legoElementProcessorFactory =
                new LegoElementProcessorFactoryImpl(iterableProvider);
        legoElementProcessorFactory.findElementProcessor(new Object());
    }
}
