package com.github.jlgrock.snp.core.domain.lego.processors;

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
import org.jvnet.hk2.annotations.Contract;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;

/**
 *
 */
@Contract
@Service
public class LegoElementProcessorFactory {
    private final TerminologyStoreDI terminologyStoreDI;
    private final ClassifiedPceStore classPceStore;

    @Inject
    LegoElementProcessorFactory(final TerminologyStoreDI terminologyStoreDIIn, final ClassifiedPceStore classPceStoreIn) {
        terminologyStoreDI = terminologyStoreDIIn;
        classPceStore = classPceStoreIn;
    }

    public LegoElementProcessorService findClassifier(final Object unmarshalledObject) throws ClassifierException {

        LegoElementProcessorService legoElementProcessorService;

        if (unmarshalledObject instanceof LegoList) {
            legoElementProcessorService = new LegoListProcessor(terminologyStoreDI, classPceStore, (LegoList) unmarshalledObject);
        } else if (unmarshalledObject instanceof Lego) {
            legoElementProcessorService = new LegoProcessor(terminologyStoreDI, classPceStore, (Lego) unmarshalledObject);
        } else if (unmarshalledObject instanceof Assertion) {
            legoElementProcessorService = new AssertionProcessor(terminologyStoreDI, classPceStore, (Assertion) unmarshalledObject);
        } else if (unmarshalledObject instanceof Pncs) {
            legoElementProcessorService = new PncsProcessor(terminologyStoreDI, classPceStore, (Pncs) unmarshalledObject);
        } else if (unmarshalledObject instanceof AssertionComponent) {
            legoElementProcessorService = new AssertionComponentProcessor(terminologyStoreDI, classPceStore, (AssertionComponent) unmarshalledObject);
        } else if (unmarshalledObject instanceof Type) {
            legoElementProcessorService = new TypeProcessor(terminologyStoreDI, classPceStore, (Type) unmarshalledObject);
        } else if (unmarshalledObject instanceof Expression) {
            legoElementProcessorService = new ExpressionProcessor(terminologyStoreDI, classPceStore, (Expression) unmarshalledObject);
        } else if (unmarshalledObject instanceof Concept) {
            legoElementProcessorService = new ConceptProcessor(terminologyStoreDI, classPceStore, (Concept) unmarshalledObject);
        } else if (unmarshalledObject instanceof Discernible) {
            legoElementProcessorService = new DiscernibleProcessor(terminologyStoreDI, classPceStore, (Discernible) unmarshalledObject);
        } else if (unmarshalledObject instanceof Qualifier) {
            legoElementProcessorService = new QualifierProcessor(terminologyStoreDI, classPceStore, (Qualifier) unmarshalledObject);
        } else if (unmarshalledObject instanceof Value) {
            legoElementProcessorService = new ValueProcessor(terminologyStoreDI, classPceStore, (Value) unmarshalledObject);
        } else if (unmarshalledObject instanceof Relation) {
            legoElementProcessorService = new RelationProcessor(terminologyStoreDI, classPceStore, (Relation) unmarshalledObject);
        } else if (unmarshalledObject instanceof RelationGroup) {
            legoElementProcessorService = new RelationGroupProcessor(terminologyStoreDI, classPceStore, (RelationGroup) unmarshalledObject);
        } else if (unmarshalledObject instanceof Destination) {
            legoElementProcessorService = new DestinationProcessor(terminologyStoreDI, classPceStore, (Destination) unmarshalledObject);
        } else if (unmarshalledObject instanceof Interval) {
            legoElementProcessorService = new IntervalProcessor(terminologyStoreDI, classPceStore, (Interval) unmarshalledObject);
        } else if (unmarshalledObject instanceof Units) {
            legoElementProcessorService = new UnitsProcessor(terminologyStoreDI, classPceStore, (Units) unmarshalledObject);
        } else if (unmarshalledObject instanceof Stamp) {
            legoElementProcessorService = new StampProcessor(terminologyStoreDI, classPceStore, (Stamp) unmarshalledObject);
        } else {
            throw new ClassifierException("Could not parse unmarshalled object.  Are you sure this is a lego document?");
        }

        return legoElementProcessorService;
    }
}
