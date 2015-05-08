package com.github.jlgrock.snp.core.model.xml.fhir;

import com.google.common.base.MoreObjects;

/**
 * The Code class represents the code element in the FHIR XML document.
 *
 */
public class Code {
	private String value;
	private Coding coding;
	
	public String getValue() {
		return value;
	}
	
	public void setValue(final String pValue) {
		value = pValue;
	}
	
	public Coding getCoding() {
		return coding;
	}
	
	public void setCoding(final Coding pCoding) {
		coding = pCoding;
	}
	
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
		.add("value", value)
		.add("coding", coding)
		.toString();
	}
	
}
