package com.deloitte.mongo.sample;

import java.util.Date;
import java.util.List;

public class Encounter {
	
	private Long _id;
	private Long patient_id; //private String patient_id; 
	//date field is found to be of type String in localhost MongoDB and of type Date in Docker VM MongoDB
	//private String date; //private String date; //private Date date;
	private Date date;
	private Long type; //private String type; //private Long type;
	private String reason_for_visit;
	
	private List<Observation> observations;

	public Long get_id() {
		return _id;
	}

	public void set_id(Long _id) {
		this._id = _id;
	}

	public Long getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(Long patient_id) {
		this.patient_id = patient_id;
	}
    
	//date field is String for localhost and Date for Docker VM
	/*
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	*/
	
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	

	public Long getType() {
		return type;
	}

	public void setType(Long type) {
		this.type = type;
	}

	public String getReason_for_visit() {
		return reason_for_visit;
	}

	public void setReason_for_visit(String reason_for_visit) {
		this.reason_for_visit = reason_for_visit;
	}

	public List<Observation> getObservations() {
		return observations;
	}

	public void setObservations(List<Observation> observations) {
		this.observations = observations;
	}
}
