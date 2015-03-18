package com.github.jlgrock.snp.core.model.parser;

import java.util.ArrayList;
import java.util.List;

/**
 * The Expression class represents the expression element in the LEGO XML document.
 *
 */
public class Expression {
	private Concept concept;
	private List<Relation> relations = new ArrayList<Relation>();
	
	public Concept getConcept() {
		return concept;
	}
	
	public void setConcept(final Concept pConcept) {
		concept = pConcept;
	}
	
	public List<Relation> getRelations() {
		return relations;
	}

	public void setRelations(final List<Relation> pRelations) {
		relations = pRelations;
	}

	/**
	 * Appends the Relation to the end of a list
	 * @param relation Relation to be appended to the list
	 */
	public void addRelation(final Relation relation) {
		relations.add(relation);
	}
	
	@Override
	public String toString() {
		return "Expression [concept=" + concept + ", relations=" + relations + "]";
	}	
	
}
