package com.github.jlgrock.snp.domain;

import com.github.jlgrock.snp.domain.primitives.SimplePrimitive;
import org.joda.time.DateTime;

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

    public void setName(final SimplePrimitive name) {
        this.name = name;
    }

    public SimplePrimitive getValue() {
        return value;
    }

    public void setValue(final SimplePrimitive value) {
        this.value = value;
    }

    public String getApplies() {
        return applies;
    }

    public void setApplies(final String applies) {
        this.applies = applies;
    }

    public DateTime getIssued() {
        return issued;
    }

    public void setIssued(final DateTime issued) {
        this.issued = issued;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(final String identifier) {
        this.identifier = identifier;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(final String subject) {
        this.subject = subject;
    }

}

