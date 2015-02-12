package com.github.jlgrock.snp.core.domain;

import com.github.jlgrock.snp.core.domain.primitives.SimplePrimitive;
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

    public void setName(final SimplePrimitive pname) {
        this.name = name;
    }

    public SimplePrimitive getValue() {
        return value;
    }

    public void setValue(final SimplePrimitive pvalue) {
        this.value = value;
    }

    public String getApplies() {
        return applies;
    }

    public void setApplies(final String papplies) {
        this.applies = applies;
    }

    public DateTime getIssued() {
        return issued;
    }

    public void setIssued(final DateTime pissued) {
        this.issued = issued;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(final String pidentifier) {
        this.identifier = identifier;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(final String psubject) {
        this.subject = subject;
    }

}

