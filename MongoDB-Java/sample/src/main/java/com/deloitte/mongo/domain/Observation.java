package com.deloitte.mongo.domain;

import com.deloitte.mongo.domain.primitives.SimplePrimitive;

import java.util.Date;

public class Observation {

    private SimplePrimitive name;
    private SimplePrimitive value;
    private String applies;
    private Date issued;

    private String identifier;
    private String subject;

    public SimplePrimitive getName() {
        return name;
    }

    public void setName(SimplePrimitive name) {
        this.name = name;
    }

    public SimplePrimitive getValue() {
        return value;
    }

    public void setValue(SimplePrimitive value) {
        this.value = value;
    }

    public String getApplies() {
        return applies;
    }

    public void setApplies(String applies) {
        this.applies = applies;
    }

    public Date getIssued() {
        return issued;
    }

    public void setIssued(Date issued) {
        this.issued = issued;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

}
