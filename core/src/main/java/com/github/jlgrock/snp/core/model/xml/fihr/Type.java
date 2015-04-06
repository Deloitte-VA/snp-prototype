package com.github.jlgrock.snp.core.model.xml.fihr;

import com.google.common.base.MoreObjects;

/**
 * The Type class represents the type element in the FIHR XML document.
 *
 */
public class Type {
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
