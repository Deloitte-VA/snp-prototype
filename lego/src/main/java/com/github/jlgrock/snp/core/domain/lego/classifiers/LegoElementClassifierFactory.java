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
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;

/**
 *
 */
@Service
public class LegoElementClassifierFactory {
    final TerminologyStoreDI terminologyStoreDI;

    @Inject
    LegoElementClassifierFactory(final TerminologyStoreDI terminologyStoreDIIn) {
        terminologyStoreDI = terminologyStoreDIIn;
    }

    public LegoElementClassifierService findClassifier(final Object unmarshalledObject) throws ClassifierException {

        LegoElementClassifierService legoElementClassifierService;

        if (unmarshalledObject instanceof LegoList) {
            legoElementClassifierService = new LegoListClassifier(terminologyStoreDI, (LegoList) unmarshalledObject);
        } else if (unmarshalledObject instanceof Lego) {
            legoElementClassifierService = new LegoClassifier(terminologyStoreDI, (Lego) unmarshalledObject);
        } else if (unmarshalledObject instanceof Assertion) {
            legoElementClassifierService = new AssertionClassifier(terminologyStoreDI, (Assertion) unmarshalledObject);
        } else if (unmarshalledObject instanceof Pncs) {
            legoElementClassifierService = new PncsClassifier(terminologyStoreDI, (Pncs) unmarshalledObject);
        } else if (unmarshalledObject instanceof AssertionComponent) {
            legoElementClassifierService = new AssertionComponentClassifier(terminologyStoreDI, (AssertionComponent) unmarshalledObject);
        } else if (unmarshalledObject instanceof Type) {
            legoElementClassifierService = new TypeClassifier(terminologyStoreDI, (Type) unmarshalledObject);
        } else if (unmarshalledObject instanceof Expression) {
            legoElementClassifierService = new ExpressionClassifier(terminologyStoreDI, (Expression) unmarshalledObject);
        } else if (unmarshalledObject instanceof Concept) {
            legoElementClassifierService = new ConceptClassifier(terminologyStoreDI, (Concept) unmarshalledObject);
        } else if (unmarshalledObject instanceof Discernible) {
            legoElementClassifierService = new DiscernibleClassifier(terminologyStoreDI, (Discernible) unmarshalledObject);
        } else if (unmarshalledObject instanceof Qualifier) {
            legoElementClassifierService = new QualifierClassifier(terminologyStoreDI, (Qualifier) unmarshalledObject);
        } else if (unmarshalledObject instanceof Value) {
            legoElementClassifierService = new ValueClassifier(terminologyStoreDI, (Value) unmarshalledObject);
        } else if (unmarshalledObject instanceof Relation) {
            legoElementClassifierService = new RelationClassifier(terminologyStoreDI, (Relation) unmarshalledObject);
        } else if (unmarshalledObject instanceof RelationGroup) {
            legoElementClassifierService = new RelationGroupClassifier(terminologyStoreDI, (RelationGroup) unmarshalledObject);
        } else if (unmarshalledObject instanceof Destination) {
            legoElementClassifierService = new DestinationClassifier(terminologyStoreDI, (Destination) unmarshalledObject);
        } else if (unmarshalledObject instanceof Interval) {
            legoElementClassifierService = new IntervalClassifier(terminologyStoreDI, (Interval) unmarshalledObject);
        } else if (unmarshalledObject instanceof Units) {
            legoElementClassifierService = new UnitsClassifier(terminologyStoreDI, (Units) unmarshalledObject);
        } else if (unmarshalledObject instanceof Stamp) {
            legoElementClassifierService = new StampClassifier(terminologyStoreDI, (Stamp) unmarshalledObject);
        } else {
            throw new ClassifierException("Could not parse unmarshalled object.  Are you sure this is a lego document?");
        }

        return legoElementClassifierService;
    }
}
