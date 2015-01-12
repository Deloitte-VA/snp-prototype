package com.deloitte.mongo.sample;

import java.util.Date;

public class Observation {
	
	private Long name;
	private Long name_type;
	private Long value;
	private Long value_type;
	private String applies;
	
	//private IssuedDate issued;  //Embedded object
	private Date issued; //private String issued;  
	
	private String identifier;
	private String subject;
	
	public Long getName() {
		return name;
	}
	public void setName(Long name) {
		this.name = name;
	}
	public Long getName_type() {
		return name_type;
	}
	public void setName_type(Long name_type) {
		this.name_type = name_type;
	}
	public Long getValue() {
		return value;
	}
	public void setValue(Long value) {
		this.value = value;
	}
	public Long getValue_type() {
		return value_type;
	}
	public void setValue_type(Long value_type) {
		this.value_type = value_type;
	}
	public String getApplies() {
		return applies;
	}
	public void setApplies(String applies) {
		this.applies = applies;
	}
	/*
	public IssuedDate getIssued() {
		return issued;
	}
	public void setIssued(IssuedDate issued) {
		this.issued = issued;
	}
	*/
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
