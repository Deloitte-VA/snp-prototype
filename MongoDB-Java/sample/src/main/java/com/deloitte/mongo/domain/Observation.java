package com.deloitte.mongo.domain;

import java.util.Date;

public class Observation {

    private Long name;
    private Integer nameType;
    private Long value;
    private Integer valueType;
    private String applies;
    private Date issued;

    private String identifier;
    private String subject;

    public Long getName() {
        return name;
    }

    public void setName(Long name) {
        this.name = name;
    }

    public Integer getNameType() {
        return nameType;
    }

    public void setNameType(Integer nameType) {
        this.nameType = nameType;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public Integer getValueType() {
        return valueType;
    }

    public void setValueType(Integer value_type) {
        valueType = valueType;
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
