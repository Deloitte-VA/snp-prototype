package com.github.jlgrock.snp.core.model.xml.lego;

import com.google.common.base.MoreObjects;

/**
 * The Type class represents the type element in the LEGO XML document.
 *
 */
public class Type {
	private Concept concept;

	public Concept getConcept() {
		return concept;
	}

	public void setConcept(final Concept pConcept) {
		concept = pConcept;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
				.add("concept", concept)
				.toString();
	}
	
}
