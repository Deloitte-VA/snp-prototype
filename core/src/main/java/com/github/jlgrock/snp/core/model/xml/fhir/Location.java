package com.github.jlgrock.snp.core.model.xml.fhir;

import com.google.common.base.MoreObjects;

/**
 * The Location class represents the location element in the FIHR XML document.
 *
 */
public class Location {
	private Code code;

	public Code getCode() {
		return code;
	}

	public void setCode(final Code pCode) {
		code = pCode;
	}
	
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
		.add("code", code)
		.toString();
	}
	
}
