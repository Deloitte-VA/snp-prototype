package com.github.jlgrock.snp.core.model.parser;

import com.google.common.base.MoreObjects;

/**
 * The Units class represents the units element in the LEGO XML document.
 *
 */
public class Units {
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
