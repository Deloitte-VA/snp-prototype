package com.github.jlgrock.snp.core.domain.lego.classifiers;

import com.github.jlgrock.snp.apis.exceptions.ClassifierException;
import com.github.jlgrock.snp.core.domain.lego.Assertion;
import com.github.jlgrock.snp.core.domain.lego.AssertionComponent;
import com.github.jlgrock.snp.core.domain.lego.Concept;
import com.github.jlgrock.snp.core.domain.lego.Destination;
import com.github.jlgrock.snp.core.domain.lego.Discernible;
import com.github.jlgrock.snp.core.domain.lego.Expression;
import com.github.jlgrock.snp.core.domain.lego.Interval;
import com.github.jlgrock.snp.core.domain.lego.Lego;
import com.github.jlgrock.snp.core.domain.lego.LegoList;
import com.github.jlgrock.snp.core.domain.lego.Pncs;
import com.github.jlgrock.snp.core.domain.lego.Qualifier;
import com.github.jlgrock.snp.core.domain.lego.Relation;
import com.github.jlgrock.snp.core.domain.lego.RelationGroup;
import com.github.jlgrock.snp.core.domain.lego.Stamp;
import com.github.jlgrock.snp.core.domain.lego.Type;
import com.github.jlgrock.snp.core.domain.lego.Units;
import com.github.jlgrock.snp.core.domain.lego.Value;
import org.jvnet.hk2.annotations.Service;

/**
 *
 */
@Service
public class LegoElementClassifierFactory {
    public LegoElementClassifierService findClassifier(final Object unmarshalledObject) throws ClassifierException {

        LegoElementClassifierService legoElementClassifierService;

        if (unmarshalledObject instanceof LegoList) {
            legoElementClassifierService = new LegoListClassifier((LegoList) unmarshalledObject);
        } else if (unmarshalledObject instanceof Lego) {
            legoElementClassifierService = new LegoClassifier((Lego) unmarshalledObject);
        } else if (unmarshalledObject instanceof Assertion) {
            legoElementClassifierService = new AssertionClassifier((Assertion) unmarshalledObject);
        } else if (unmarshalledObject instanceof Pncs) {
            legoElementClassifierService = new PncsClassifier((Pncs) unmarshalledObject);
        } else if (unmarshalledObject instanceof AssertionComponent) {
            legoElementClassifierService = new AssertionComponentClassifier((AssertionComponent) unmarshalledObject);
        } else if (unmarshalledObject instanceof Type) {
            legoElementClassifierService = new TypeClassifier((Type) unmarshalledObject);
        } else if (unmarshalledObject instanceof Expression) {
            legoElementClassifierService = new ExpressionClassifier((Expression) unmarshalledObject);
        } else if (unmarshalledObject instanceof Concept) {
            legoElementClassifierService = new ConceptClassifier((Concept) unmarshalledObject);
        } else if (unmarshalledObject instanceof Discernible) {
            legoElementClassifierService = new DiscernibleClassifier((Discernible) unmarshalledObject);
        } else if (unmarshalledObject instanceof Qualifier) {
            legoElementClassifierService = new QualifierClassifier((Qualifier) unmarshalledObject);
        } else if (unmarshalledObject instanceof Value) {
            legoElementClassifierService = new ValueClassifier((Value) unmarshalledObject);
        } else if (unmarshalledObject instanceof Relation) {
            legoElementClassifierService = new RelationClassifier((Relation) unmarshalledObject);
        } else if (unmarshalledObject instanceof RelationGroup) {
            legoElementClassifierService = new RelationGroupClassifier((RelationGroup) unmarshalledObject);
        } else if (unmarshalledObject instanceof Destination) {
            legoElementClassifierService = new DestinationClassifier((Destination) unmarshalledObject);
        } else if (unmarshalledObject instanceof Interval) {
            legoElementClassifierService = new IntervalClassifier((Interval) unmarshalledObject);
        } else if (unmarshalledObject instanceof Units) {
            legoElementClassifierService = new UnitsClassifier((Units) unmarshalledObject);
        } else if (unmarshalledObject instanceof Stamp) {
            legoElementClassifierService = new StampClassifier((Stamp) unmarshalledObject);
        } else {
            throw new ClassifierException("Could not parse unmarshalled object.  Are you sure this is a lego document?");
        }

        return legoElementClassifierService;
    }
}
