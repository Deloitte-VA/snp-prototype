package com.github.jlgrock.snp.core.model.xml.fihr;
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
	
}
