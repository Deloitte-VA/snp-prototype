package com.github.jlgrock.snp.core.model.xml.fhir;

import com.google.common.base.MoreObjects;

/**
 * The System class represents the system element in the FIHR XML document.
 *
 */
public class System {
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
