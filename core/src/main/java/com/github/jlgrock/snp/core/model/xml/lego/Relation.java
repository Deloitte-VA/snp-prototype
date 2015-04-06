package com.github.jlgrock.snp.core.model.xml.lego;

import com.google.common.base.MoreObjects;

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
		return MoreObjects.toStringHelper(this)
				.add("type", type)
				.add("destination", destination)
				.toString();
	}	
	
}
