package com.github.jlgrock.snp.core.model.parser;

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
		return "Type [concept=" + concept + "]";
	}
	
}
