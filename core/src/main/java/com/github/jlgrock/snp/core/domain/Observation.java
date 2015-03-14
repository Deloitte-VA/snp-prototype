package com.github.jlgrock.snp.core.domain;

import com.github.jlgrock.snp.core.domain.primitives.SimplePrimitive;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.time.Instant;

/**
 * 
 * An Observation is a single measurement or perception during a patient visit.
 */
public class Observation {

    private SimplePrimitive name;
    private SimplePrimitive value;
    private String applies;
    private Instant issued;

    private String identifier;
    private String subject;

    public SimplePrimitive getName() {
        return name;
    }

    public void setName(final SimplePrimitive pName) {
        this.name = pName;
    }

    public SimplePrimitive getValue() {
        return value;
    }

    public void setValue(final SimplePrimitive pValue) {
        this.value = pValue;
    }

    public String getApplies() {
        return applies;
    }

    public void setApplies(final String pApplies) {
        this.applies = pApplies;
    }

    public Instant getIssued() {
        return issued;
    }

    public void setIssued(final Instant pIssued) {
        this.issued = pIssued;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(final String pIdentifier) {
        this.identifier = pIdentifier;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(final String pSubject) {
        this.subject = pSubject;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Observation that = (Observation) o;

        return Objects.equal(name, that.name) &&
                Objects.equal(value, that.value) &&
                Objects.equal(applies, that.applies) &&
                Objects.equal(issued, that.issued) &&
                Objects.equal(identifier, that.identifier) &&
                Objects.equal(subject, that.subject);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name, value, applies, issued, identifier, subject);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("name", name)
                .add("value", value)
                .add("applies", applies)
                .add("issued", issued)
                .add("identifier", identifier)
                .add("subject", subject)
                .toString();
    }
}

