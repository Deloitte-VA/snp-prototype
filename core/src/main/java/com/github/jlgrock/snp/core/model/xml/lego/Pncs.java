package com.github.jlgrock.snp.core.model.xml.lego;

import com.google.common.base.MoreObjects;

/**
 * The Pncs class represents the pncs element in the LEGO XML document.
 *
 */
public class Pncs {
	private String value;
	private String name;
	private String id;
	
	public String getValue() {
		return value;
	}
	
	public void setValue(final String pValue) {
		value = pValue;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(final String pName) {
		name = pName;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(final String pId) {
		id = pId;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
				.add("value", value)
				.add("name", name)
				.add("id", id)
				.toString();
	}	
	
}
