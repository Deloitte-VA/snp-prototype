package com.github.jlgrock.snp.core.model;

import java.util.ArrayList;
import java.util.List;

public class Expression {
	private Concept concept;
	private List<Relation> relations = new ArrayList<Relation>();
	
	public Concept getConcept() {
		return concept;
	}
	
	public void setConcept(Concept concept) {
		this.concept = concept;
	}
	
	public List<Relation> getRelations() {
		return relations;
	}

	public void setRelations(List<Relation> relations) {
		this.relations = relations;
	}

	public void addRelation(Relation relation) {
		relations.add(relation);
	}
	
	@Override
	public String toString() {
		return "Expression [concept=" + concept + ", relations=" + relations + "]";
	}	
	
}
