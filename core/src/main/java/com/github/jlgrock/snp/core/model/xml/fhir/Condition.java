package com.github.jlgrock.snp.core.model.xml.fhir;

import com.google.common.base.MoreObjects;

/**
 * The Condition class represents the Condition element in the FIHR XML document.
 *
 */
public class Condition {
	private String subject;
	private String encounter;
	private String asserter;
	private String dateAsserted;
	private Status status;
	private Code code;
	private Category category;
	private Onset onset;
	private Location location;
	private String notes;
	
	public String getSubject() {
		return subject;
	}
	
	public void setSubject(final String pSubject) {
		subject = pSubject;
	}
	
	public String getEncounter() {
		return encounter;
	}
	
	public void setEncounter(final String pEncounter) {
		encounter = pEncounter;
	}
	
	public String getAsserter() {
		return asserter;
	}
	
	public void setAsserter(final String pAsserter) {
		asserter = pAsserter;
	}
	
	public String getDateAsserted() {
		return dateAsserted;
	}
	
	public void setDateAsserted(final String pDateAsserted) {
		dateAsserted = pDateAsserted;
	}
	
	public Status getStatus() {
		return status;
	}
	
	public void setStatus(final Status pStatus) {
		status = pStatus;
	}

	public Code getCode() {
		return code;
	}

	public void setCode(final Code pCode) {
		code = pCode;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(final Category pCategory) {
		category = pCategory;
	}

	public Onset getOnset() {
		return onset;
	}

	public void setOnset(final Onset pOnset) {
		onset = pOnset;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(final Location pLocation) {
		location = pLocation;
	}
	
	public String getNotes() {
		return notes;
	}
	
	public void setNotes(final String pNotes) {
		notes = pNotes;
	}
	
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
		.add("subject", subject)
		.add("encounter", encounter)
		.add("asserter", asserter)
		.add("dateAsserted", dateAsserted)
		.add("status", status)
		.add("code", code)
		.add("category", category)
		.add("onset", onset)
		.add("location", location)
		.add("notes", notes)
		.toString();
	}
	
}
