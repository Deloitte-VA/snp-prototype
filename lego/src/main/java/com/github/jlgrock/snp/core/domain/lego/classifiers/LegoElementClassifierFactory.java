package com.github.jlgrock.snp.core.domain.lego.classifiers;

import com.github.jlgrock.snp.apis.exceptions.ClassifierException;
import com.github.jlgrock.snp.domain.data.ClassifiedPceStore;
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

import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;

/**
 *
 */
@Service
public class LegoElementClassifierFactory {
    private final TerminologyStoreDI terminologyStoreDI;
    private final ClassifiedPceStore classPceStore;

    @Inject
    LegoElementClassifierFactory(final TerminologyStoreDI terminologyStoreDIIn, final ClassifiedPceStore classPceStoreIn) {
        terminologyStoreDI = terminologyStoreDIIn;
        classPceStore = classPceStoreIn;
    }

    public LegoElementClassifierService findClassifier(final Object unmarshalledObject) throws ClassifierException {

        LegoElementClassifierService legoElementClassifierService;

        if (unmarshalledObject instanceof LegoList) {
            legoElementClassifierService = new LegoListClassifier(terminologyStoreDI, classPceStore, (LegoList) unmarshalledObject);
        } else if (unmarshalledObject instanceof Lego) {
            legoElementClassifierService = new LegoClassifier(terminologyStoreDI, classPceStore, (Lego) unmarshalledObject);
        } else if (unmarshalledObject instanceof Assertion) {
            legoElementClassifierService = new AssertionClassifier(terminologyStoreDI, classPceStore, (Assertion) unmarshalledObject);
        } else if (unmarshalledObject instanceof Pncs) {
            legoElementClassifierService = new PncsClassifier(terminologyStoreDI, classPceStore, (Pncs) unmarshalledObject);
        } else if (unmarshalledObject instanceof AssertionComponent) {
            legoElementClassifierService = new AssertionComponentClassifier(terminologyStoreDI, classPceStore, (AssertionComponent) unmarshalledObject);
        } else if (unmarshalledObject instanceof Type) {
            legoElementClassifierService = new TypeClassifier(terminologyStoreDI, classPceStore, (Type) unmarshalledObject);
        } else if (unmarshalledObject instanceof Expression) {
            legoElementClassifierService = new ExpressionClassifier(terminologyStoreDI, classPceStore, (Expression) unmarshalledObject);
        } else if (unmarshalledObject instanceof Concept) {
            legoElementClassifierService = new ConceptClassifier(terminologyStoreDI, classPceStore, (Concept) unmarshalledObject);
        } else if (unmarshalledObject instanceof Discernible) {
            legoElementClassifierService = new DiscernibleClassifier(terminologyStoreDI, classPceStore, (Discernible) unmarshalledObject);
        } else if (unmarshalledObject instanceof Qualifier) {
            legoElementClassifierService = new QualifierClassifier(terminologyStoreDI, classPceStore, (Qualifier) unmarshalledObject);
        } else if (unmarshalledObject instanceof Value) {
            legoElementClassifierService = new ValueClassifier(terminologyStoreDI, classPceStore, (Value) unmarshalledObject);
        } else if (unmarshalledObject instanceof Relation) {
            legoElementClassifierService = new RelationClassifier(terminologyStoreDI, classPceStore, (Relation) unmarshalledObject);
        } else if (unmarshalledObject instanceof RelationGroup) {
            legoElementClassifierService = new RelationGroupClassifier(terminologyStoreDI, classPceStore, (RelationGroup) unmarshalledObject);
        } else if (unmarshalledObject instanceof Destination) {
            legoElementClassifierService = new DestinationClassifier(terminologyStoreDI, classPceStore, (Destination) unmarshalledObject);
        } else if (unmarshalledObject instanceof Interval) {
            legoElementClassifierService = new IntervalClassifier(terminologyStoreDI, classPceStore, (Interval) unmarshalledObject);
        } else if (unmarshalledObject instanceof Units) {
            legoElementClassifierService = new UnitsClassifier(terminologyStoreDI, classPceStore, (Units) unmarshalledObject);
        } else if (unmarshalledObject instanceof Stamp) {
            legoElementClassifierService = new StampClassifier(terminologyStoreDI, classPceStore, (Stamp) unmarshalledObject);
        } else {
            throw new ClassifierException("Could not parse unmarshalled object.  Are you sure this is a lego document?");
        }

        return legoElementClassifierService;
    }
}
