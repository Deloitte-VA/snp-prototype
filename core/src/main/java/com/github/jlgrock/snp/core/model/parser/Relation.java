package com.github.jlgrock.snp.core.model.parser;

/**
 * The Relation class represents the relation element in the LEGO XML document.
 *
 */
public class Relation {
	private Type type;
	private Destination destination;
	
	public Type getType() {
		return type;
	}
	
	public void setType(final Type pType) {
		type = pType;
	}
	
	public Destination getDestination() {
		return destination;
	}
	
	public void setDestination(final Destination pDestination) {
		destination = pDestination;
	}
	
	@Override
	public String toString() {
		return "Relation [type=" + type + ", destination=" + destination + "]";
	}	
	
}
