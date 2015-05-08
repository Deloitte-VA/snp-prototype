package com.github.jlgrock.snp.core.model.xml.fhir;

import com.google.common.base.MoreObjects;

/**
 * The Coding class represents the coding element in the FHIR XML document.
 *
 */
public class Coding {
	private System system;
	private Code code;
	private Display display;
	
	public System getSystem() {
		return system;
	}
	
	public void setSystem(final System pSystem) {
		system = pSystem;
	}
	
	public Code getCode() {
		return code;
	}
	
	public void setCode(final Code pCode) {
		code = pCode;
	}
	
	public Display getDisplay() {
		return display;
	}
	
	public void setDisplay(final Display pDisplay) {
		display = pDisplay;
	}	
	
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
		.add("system", system)
		.add("code", code)
		.add("display", display)
		.toString();
	}
	
}
