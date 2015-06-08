package com.github.jlgrock.snp.core.domain.lego.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
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
import com.github.jlgrock.snp.domain.data.ClassifiedPceStore;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;

/**
 *
 */
@Service
public class LegoElementProcessorFactoryImpl implements LegoElementProcessorFactory {
    private final LogicGraphClassifier logicGraphClassifier;
    private final ClassifiedPceStore classPceStore;

    @Inject
    LegoElementProcessorFactoryImpl(final LogicGraphClassifier logicGraphClassifierIn, final ClassifiedPceStore classPceStoreIn) {
        logicGraphClassifier = logicGraphClassifierIn;
        classPceStore = classPceStoreIn;
    }

    @Override
    public LegoElementProcessorService findElementProcessor(final Object unmarshalledObject) throws ClassifierException {

        LegoElementProcessorService legoElementProcessorService;

        if (unmarshalledObject instanceof LegoList) {
            legoElementProcessorService = new LegoListProcessor(logicGraphClassifier, classPceStore, (LegoList) unmarshalledObject);
        } else if (unmarshalledObject instanceof Lego) {
            legoElementProcessorService = new LegoProcessor(logicGraphClassifier, classPceStore, (Lego) unmarshalledObject);
        } else if (unmarshalledObject instanceof Assertion) {
            legoElementProcessorService = new AssertionProcessor(logicGraphClassifier, classPceStore, (Assertion) unmarshalledObject);
        } else if (unmarshalledObject instanceof Pncs) {
            legoElementProcessorService = new PncsProcessor(logicGraphClassifier, classPceStore, (Pncs) unmarshalledObject);
        } else if (unmarshalledObject instanceof AssertionComponent) {
            legoElementProcessorService = new AssertionComponentProcessor(logicGraphClassifier, classPceStore, (AssertionComponent) unmarshalledObject);
        } else if (unmarshalledObject instanceof Type) {
            legoElementProcessorService = new TypeProcessor(logicGraphClassifier, classPceStore, (Type) unmarshalledObject);
        } else if (unmarshalledObject instanceof Expression) {
            legoElementProcessorService = new ExpressionProcessor(logicGraphClassifier, classPceStore, (Expression) unmarshalledObject);
        } else if (unmarshalledObject instanceof Concept) {
            legoElementProcessorService = new ConceptProcessor(logicGraphClassifier, classPceStore, (Concept) unmarshalledObject);
        } else if (unmarshalledObject instanceof Discernible) {
            legoElementProcessorService = new DiscernibleProcessor(logicGraphClassifier, classPceStore, (Discernible) unmarshalledObject);
        } else if (unmarshalledObject instanceof Qualifier) {
            legoElementProcessorService = new QualifierProcessor(logicGraphClassifier, classPceStore, (Qualifier) unmarshalledObject);
        } else if (unmarshalledObject instanceof Value) {
            legoElementProcessorService = new ValueProcessor(logicGraphClassifier, classPceStore, (Value) unmarshalledObject);
        } else if (unmarshalledObject instanceof Relation) {
            legoElementProcessorService = new RelationProcessor(logicGraphClassifier, classPceStore, (Relation) unmarshalledObject);
        } else if (unmarshalledObject instanceof RelationGroup) {
            legoElementProcessorService = new RelationGroupProcessor(logicGraphClassifier, classPceStore, (RelationGroup) unmarshalledObject);
        } else if (unmarshalledObject instanceof Destination) {
            legoElementProcessorService = new DestinationProcessor(logicGraphClassifier, classPceStore, (Destination) unmarshalledObject);
        } else if (unmarshalledObject instanceof Interval) {
            legoElementProcessorService = new IntervalProcessor(logicGraphClassifier, classPceStore, (Interval) unmarshalledObject);
        } else if (unmarshalledObject instanceof Units) {
            legoElementProcessorService = new UnitsProcessor(logicGraphClassifier, classPceStore, (Units) unmarshalledObject);
        } else if (unmarshalledObject instanceof Stamp) {
            legoElementProcessorService = new StampProcessor(logicGraphClassifier, classPceStore, (Stamp) unmarshalledObject);
        } else {
            throw new ClassifierException("Could not parse unmarshalled object.  Are you sure this is a lego document?");
        }

        return legoElementProcessorService;
    }
}
