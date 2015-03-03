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

    public void setName(final SimplePrimitive pname) {
        this.name = pname;
    }

    public SimplePrimitive getValue() {
        return value;
    }

    public void setValue(final SimplePrimitive pvalue) {
        this.value = pvalue;
    }

    public String getApplies() {
        return applies;
    }

    public void setApplies(final String papplies) {
        this.applies = papplies;
    }

    public DateTime getIssued() {
        return issued;
    }

    public void setIssued(final DateTime pissued) {
        this.issued = pissued;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(final String pidentifier) {
        this.identifier = pidentifier;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(final String psubject) {
        this.subject = psubject;
    }

}

