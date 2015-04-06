package com.github.jlgrock.snp.core.model.xml.fihr;
/**
 * The Code class represents the code element in the FIHR XML document.
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
	
}
