package com.github.jlgrock.snp.core.domain.lego;

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
import com.google.common.base.MoreObjects;

import java.util.Objects;


//TODO delete
/**
 * A simple wrapper class to manage multiple top-level xml elements.
 */
public class LegoEnvelope {
    private final LegoList legoList;
    private final Lego lego;
    private final Assertion assertion;
    private final Pncs pncs;
    private final AssertionComponent assertionComponent;
    private final Type type;
    private final Expression expression;
    private final Concept concept;
    private final Discernible discernible;
    private final Qualifier qualifier;
    private final Value value;
    private final Relation relation;
    private final RelationGroup relationGroup;
    private final Destination destination;
    private final Interval interval;
    private final Units units;
    private final Stamp stamp;

    public LegoEnvelope(final LegoList legoListIn) {
        this(legoListIn, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null);
    }

    public LegoEnvelope(final Lego legoIn) {
        this(null, legoIn, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null);
    }

    public LegoEnvelope(final Assertion assertionIn) {
        this(null, null, assertionIn, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null);
    }

    public LegoEnvelope(final Pncs pncsIn) {
        this(null, null, null, pncsIn, null, null, null, null,
                null, null, null, null, null, null, null, null, null);
    }

    public LegoEnvelope(final AssertionComponent assertionComponentIn) {
        this(null, null, null, null, assertionComponentIn, null, null, null,
                null, null, null, null, null, null, null, null, null);
    }

    public LegoEnvelope(final Type typeIn) {
        this(null, null, null, null, null, typeIn, null, null,
                null, null, null, null, null, null, null, null, null);
    }

    public LegoEnvelope(final Expression expressionIn) {
        this(null, null, null, null, null, null, expressionIn, null,
                null, null, null, null, null, null, null, null, null);
    }

    public LegoEnvelope(final Concept conceptIn) {
        this(null, null, null, null, null, null, null, conceptIn,
                null, null, null, null, null, null, null, null, null);
    }

    public LegoEnvelope(final Discernible discernibleIn) {
        this(null, null, null, null, null, null, null, null,
                discernibleIn, null, null, null, null, null, null, null, null);
    }

    public LegoEnvelope(final Qualifier qualifierIn) {
        this(null, null, null, null, null, null, null, null,
                null, qualifierIn, null, null, null, null, null, null, null);
    }

    public LegoEnvelope(final Value valueIn) {
        this(null, null, null, null, null, null, null, null,
                null, null, valueIn, null, null, null, null, null, null);
    }

    public LegoEnvelope(final Relation relationIn) {
        this(null, null, null, null, null, null, null, null,
                null, null, null, relationIn, null, null, null, null, null);
    }

    public LegoEnvelope(final RelationGroup relationGroupIn) {
        this(null, null, null, null, null, null, null, null,
                null, null, null, null, relationGroupIn, null, null, null, null);
    }

    public LegoEnvelope(final Destination destinationIn) {
        this(null, null, null, null, null, null, null, null,
                null, null, null, null, null, destinationIn, null, null, null);
    }

    public LegoEnvelope(final Interval intervalIn) {
        this(null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, intervalIn, null, null);
    }

    public LegoEnvelope(final Units unitsIn) {
        this(null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, unitsIn, null);
    }

    public LegoEnvelope(final Stamp stampIn) {
        this(null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, stampIn);
    }

    private LegoEnvelope(final LegoList legoListIn,
            final Lego legoIn,
            final Assertion assertionIn,
            final Pncs pncsIn,
            final AssertionComponent assertionComponentIn,
            final Type typeIn,
            final Expression expressionIn,
            final Concept conceptIn,
            final Discernible discernibleIn,
            final Qualifier qualifierIn,
            final Value valueIn,
            final Relation relationIn,
            final RelationGroup relationGroupIn,
            final Destination destinationIn,
            final Interval intervalIn,
            final Units unitsIn,
            final Stamp stampIn) {
        legoList = legoListIn;
        lego = legoIn;
        assertion = assertionIn;
        pncs = pncsIn;
        assertionComponent = assertionComponentIn;
        type = typeIn;
        expression = expressionIn;
        concept = conceptIn;
        discernible = discernibleIn;
        qualifier = qualifierIn;
        value = valueIn;
        relation = relationIn;
        relationGroup = relationGroupIn;
        destination = destinationIn;
        interval = intervalIn;
        units = unitsIn;
        stamp = stampIn;
    }

    public LegoList getLegoList() {
        return legoList;
    }

    public Lego getLego() {
        return lego;
    }

    public Assertion getAssertion() {
        return assertion;
    }

    public Pncs getPncs() {
        return pncs;
    }

    public AssertionComponent getAssertionComponent() {
        return assertionComponent;
    }

    public Type getType() {
        return type;
    }

    public Expression getExpression() {
        return expression;
    }

    public Concept getConcept() {
        return concept;
    }

    public Discernible getDiscernible() {
        return discernible;
    }

    public Qualifier getQualifier() {
        return qualifier;
    }

    public Value getValue() {
        return value;
    }

    public Relation getRelation() {
        return relation;
    }

    public RelationGroup getRelationGroup() {
        return relationGroup;
    }

    public Destination getDestination() {
        return destination;
    }

    public Interval getInterval() {
        return interval;
    }

    public Units getUnits() {
        return units;
    }

    public Stamp getStamp() {
        return stamp;
    }

    @Override
    public int hashCode() {
        return Objects.hash(legoList, lego, assertion, pncs, assertionComponent, type, expression, concept, discernible, qualifier, value, relation, relationGroup, destination, interval, units, stamp);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final LegoEnvelope other = (LegoEnvelope) obj;
        return Objects.equals(this.legoList, other.legoList)
                && Objects.equals(this.lego, other.lego)
                && Objects.equals(this.assertion, other.assertion)
                && Objects.equals(this.pncs, other.pncs)
                && Objects.equals(this.assertionComponent, other.assertionComponent)
                && Objects.equals(this.type, other.type)
                && Objects.equals(this.expression, other.expression)
                && Objects.equals(this.concept, other.concept)
                && Objects.equals(this.discernible, other.discernible)
                && Objects.equals(this.qualifier, other.qualifier)
                && Objects.equals(this.value, other.value)
                && Objects.equals(this.relation, other.relation)
                && Objects.equals(this.relationGroup, other.relationGroup)
                && Objects.equals(this.destination, other.destination)
                && Objects.equals(this.interval, other.interval)
                && Objects.equals(this.units, other.units)
                && Objects.equals(this.stamp, other.stamp);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("legoList", legoList)
                .add("lego", lego)
                .add("assertion", assertion)
                .add("pncs", pncs)
                .add("assertionComponent", assertionComponent)
                .add("type", type)
                .add("expression", expression)
                .add("concept", concept)
                .add("discernible", discernible)
                .add("qualifier", qualifier)
                .add("value", value)
                .add("relation", relation)
                .add("relationGroup", relationGroup)
                .add("destination", destination)
                .add("interval", interval)
                .add("units", units)
                .add("stamp", stamp)
                .toString();
    }
}
