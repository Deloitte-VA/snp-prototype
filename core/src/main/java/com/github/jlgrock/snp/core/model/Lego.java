package com.github.jlgrock.snp.core.model;

public class Lego {
	private String uuid;
	private Stamp stamp;
	private Pncs pncs;
	private Assertion assertion;
	private String comment;
	
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	public Stamp getStamp() {
		return stamp;
	}

	public void setStamp(Stamp stamp) {
		this.stamp = stamp;
	}
	
	public Pncs getPncs() {
		return pncs;
	}

	public void setPncs(Pncs pncs) {
		this.pncs = pncs;
	}

	public Assertion getAssertion() {
		return assertion;
	}

	public void setAssertion(Assertion assertion) {
		this.assertion = assertion;
	}
	
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Lego [uuid=" + uuid + ", stamp=" + stamp + ", pncs=" + pncs + ", assertion=" + assertion + ", comment="
				+ comment + "]";
	}
	
}
