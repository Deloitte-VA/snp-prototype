package com.github.jlgrock.snp.core.model.parser;

/**
 * The Lego class represents the lego element in the LEGO XML document.
 *
 */
public class Lego {
	private String uuid;
	private Stamp stamp;
	private Pncs pncs;
	private Assertion assertion;
	private String comment;
	
	public String getUuid() {
		return uuid;
	}

	public void setUuid(final String pUuid) {
		uuid = pUuid;
	}
	
	public Stamp getStamp() {
		return stamp;
	}

	public void setStamp(final Stamp pStamp) {
		stamp = pStamp;
	}
	
	public Pncs getPncs() {
		return pncs;
	}

	public void setPncs(final Pncs pPncs) {
		pncs = pPncs;
	}

	public Assertion getAssertion() {
		return assertion;
	}

	public void setAssertion(final Assertion pAssertion) {
		assertion = pAssertion;
	}
	
	public String getComment() {
		return comment;
	}

	public void setComment(final String pComment) {
		comment = pComment;
	}

	@Override
	public String toString() {
		return "Lego [uuid=" + uuid + ", stamp=" + stamp + ", pncs=" + pncs + ", assertion=" + assertion + ", comment="
				+ comment + "]";
	}
	
}
