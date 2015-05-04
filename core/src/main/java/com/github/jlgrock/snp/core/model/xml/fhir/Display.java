package com.github.jlgrock.snp.core.model.xml.fhir;

import com.google.common.base.MoreObjects;

/**
 * The Display class represents the display element in the FIHR XML document.
 *
 */
public class Display {
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(final String pValue) {
		value = pValue;
	}
	
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
		.add("value", value)
		.toString();
	}
	
}
