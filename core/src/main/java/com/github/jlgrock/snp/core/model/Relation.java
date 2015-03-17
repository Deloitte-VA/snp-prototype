package com.github.jlgrock.snp.core.model;

public class Relation {
	private Type type;
	private Destination destination;
	
	public Type getType() {
		return type;
	}
	
	public void setType(Type type) {
		this.type = type;
	}
	
	public Destination getDestination() {
		return destination;
	}
	
	public void setDestination(Destination destination) {
		this.destination = destination;
	}
	
	@Override
	public String toString() {
		return "Relation [type=" + type + ", destination=" + destination + "]";
	}	
	
}
