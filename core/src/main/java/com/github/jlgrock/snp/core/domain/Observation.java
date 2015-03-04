package com.github.jlgrock.snp.core.domain;

import com.github.jlgrock.snp.core.domain.primitives.SimplePrimitive;
import org.joda.time.DateTime;

/**
 * 
 * An Observation is a single measurement or perception during a patient visit.
 */
public class Observation {

    private SimplePrimitive name;
    private SimplePrimitive value;
    private String applies;
    private DateTime issued;

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

    public DateTime getIssued() {
        return issued;
    }

    public void setIssued(final DateTime pIssued) {
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

}

