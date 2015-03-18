package com.github.jlgrock.snp.core.model.parser;

/**
 * The AssertionComponent class represents the assertionComponent element in the LEGO XML document.
 *
 */
public class AssertionComponent {
	private String uuid;
	private Type type;
	
	public String getUuid() {
		return uuid;
	}
	public void setUuid(final String pUuid) {
		uuid = pUuid;
	}
	public Type getType() {
		return type;
	}
	public void setType(final Type pType) {
		type = pType;
	}
	
	@Override
	public String toString() {
		return "AssertionComponent [uuid=" + uuid + ", type=" + type + "]";
	}
	
}
