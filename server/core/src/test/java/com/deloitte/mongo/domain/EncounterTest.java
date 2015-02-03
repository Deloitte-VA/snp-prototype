package com.deloitte.mongo.domain;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import com.deloitte.mongo.domain.primitives.IntegerPrimitive;
import com.deloitte.mongo.domain.primitives.StringPrimitive;

public class EncounterTest {

	@Test
	public void test() {
				
	    Long ln1 = new Long(222015);		
		Patient pt1 = Mockito.mock (Patient.class);
		Date dt1 = Mockito.mock (Date.class);
		Integer it1 = 212015;
	    String st1 = "Brady";
			
	    public Date getDate() {
	        return date;
	    }

	    public void setDate(Date date) {
	        this.date = date;
	    }

	    public String getReasonForVisit() {
	        return reasonForVisit;
	    }

	    public void setReasonForVisit(String reasonForVisit) {
	        this.reasonForVisit = reasonForVisit;
	    }

	    public List<Observation> getObservations() {
	        return observations;
	    }

	    public void setObservations(List<Observation> observations) {
	        this.observations = observations;
	    }

	    public Integer getType() {
	        return type;
	    }

	    public void setType(Integer type) {
	        this.type = type;
	    }

	    private List<Observation> observations;

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public Long getId() {
	        return id;
	    }

	    public Patient getPatient() {
	        return patient;
	    }

	    public void setPatient(Patient patient) {
	        this.patient = patient;
	    }	
		
		
		
		
		
	}

}
