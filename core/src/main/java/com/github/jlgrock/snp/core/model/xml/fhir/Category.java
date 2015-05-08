package com.github.jlgrock.snp.core.model.xml.fhir;

import com.google.common.base.MoreObjects;

/**
 * The Category class represents the category element in the FHIR XML document.
 *
 */
public class Category {
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
