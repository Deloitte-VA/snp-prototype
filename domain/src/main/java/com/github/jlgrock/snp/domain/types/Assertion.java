package com.github.jlgrock.snp.domain.types;

import com.github.jlgrock.snp.domain.types.primitives.SimplePrimitive;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.time.Instant;

/**
 * 
 * An Assertion is a single measurement or perception during a patient visit.
 */
public class Assertion {

    private SimplePrimitive observable;
    private SimplePrimitive value;
    private SimplePrimitive provenance;
    private String applies;
    private Instant issued;
    private TimeSpan timeSpan;

    private String identifier;
    private String subject;
    private String fhirId;

    public String getFhirId() {
        return fhirId;
    }

    public void setFhirId(final String fhirIdIn) {
        fhirId = fhirIdIn;
    }

    public SimplePrimitive getObservable() {
        return observable;
    }

    public void setObservable(final SimplePrimitive pObservable) {
        this.observable = pObservable;
    }

    public SimplePrimitive getValue() {
        return value;
    }

    public void setValue(final SimplePrimitive pValue) {
        this.value = pValue;
    }
    
    public SimplePrimitive getProvenance() {
    	return provenance;
    }
    
    public void setProvenance(final SimplePrimitive pProvenance) {
    	this.provenance = pProvenance;
    }
    
    public TimeSpan getTimeSpan() {
    	return timeSpan;
    }
    
    public void setTimeSpan(final TimeSpan pTimeSpan) {
    	this.timeSpan = pTimeSpan;
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
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Assertion that = (Assertion) o;

        return Objects.equal(observable, that.observable) &&
                Objects.equal(value, that.value) &&
                Objects.equal(provenance, that.provenance) &&
                Objects.equal(timeSpan, that.timeSpan) &&
                Objects.equal(applies, that.applies) &&
                Objects.equal(issued, that.issued) &&
                Objects.equal(identifier, that.identifier) &&
                Objects.equal(fhirId, that.fhirId) &&
                Objects.equal(subject, that.subject);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(observable, value, applies, issued, identifier, subject);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("observable", observable)
                .add("value", value)
                .add("provenance", provenance)
                .add("timeSpan", timeSpan)
                .add("applies", applies)
                .add("issued", issued)
                .add("identifier", identifier)
                .add("subject", subject)
                .add("fhirId", fhirId)
                .toString();
    }
}

