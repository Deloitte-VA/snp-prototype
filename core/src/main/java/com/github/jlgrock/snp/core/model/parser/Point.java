package com.github.jlgrock.snp.core.model.parser;

/**
 * The Point class represents the point element in the LEGO XML document.
 *
 */
public class Point {
	private String type;
	private String value;
	
	public String getType() {
		return type;
	}

	public void setType(final String pType) {
		type = pType;
	}

	public String getValue() {
		return value;
	}

	public void setValue(final String pValue) {
		value = pValue;
	}

	@Override
	public String toString() {
		return "Point [type=" + type + ", value=" + value + "]";
	}
	
}
