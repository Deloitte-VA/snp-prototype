package com.github.jlgrock.snp.core.model;

public class Units {
	private Concept concept;

	public Concept getConcept() {
		return concept;
	}

	public void setConcept(Concept concept) {
		this.concept = concept;
	}

	@Override
	public String toString() {
		return "Units [concept=" + concept + "]";
	}
	
}
