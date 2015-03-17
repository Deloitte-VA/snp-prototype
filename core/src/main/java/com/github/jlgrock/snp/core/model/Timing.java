package com.github.jlgrock.snp.core.model;

public class Timing {
	private Bound bound;
	private Units units;
	
	public Bound getBound() {
		return bound;
	}

	public void setBound(Bound bound) {
		this.bound = bound;
	}

	public Units getUnits() {
		return units;
	}

	public void setUnits(Units units) {
		this.units = units;
	}

	@Override
	public String toString() {
		return "Timing [bound=" + bound + ", units=" + units + "]";
	}
	
}
