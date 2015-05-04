package com.github.jlgrock.snp.core.model.xml.fhir;

import com.google.common.base.MoreObjects;

/**
 * The Resource class represents the resource element in the FIHR XML document.
 *
 */
public class Resource {
	private Condition condition;

	public Condition getCondition() {
		return condition;
	}

	public void setCondition(final Condition pCondition) {
		condition = pCondition;
	}
	
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
		.add("condition", condition)
		.toString();
	}
	
}
