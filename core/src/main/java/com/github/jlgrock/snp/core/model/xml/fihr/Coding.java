package com.github.jlgrock.snp.core.model.xml.fihr;
/**
 * The Coding class represents the coding element in the FIHR XML document.
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
	
}
