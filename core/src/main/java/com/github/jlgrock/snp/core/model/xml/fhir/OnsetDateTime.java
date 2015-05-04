package com.github.jlgrock.snp.core.model.xml.fhir;

import com.google.common.base.MoreObjects;

/**
 * The OnsetDateTime class represents the onsetDateTime element in the FIHR XML document.
 *
 */
public class OnsetDateTime {
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
