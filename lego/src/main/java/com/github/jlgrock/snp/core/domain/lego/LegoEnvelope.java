package com.github.jlgrock.snp.core.domain.lego;

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
    private final Relation relationGroup;
    private final Destination destination;
    private final Interval interval;
    private final Units units;
    private final Stamp stamp;

    LegoEnvelope(final LegoList legoListIn,
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
            final Relation relationGroupIn,
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

    public Relation getRelationGroup() {
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
}
