package com.github.jlgrock.snp.core.model.parser;

/**
 * The Timing class represents the timing element in the LEGO XML document.
 *
 */
public class Timing {
	private Bound bound;
	private Units units;
	
	public Bound getBound() {
		return bound;
	}

	public void setBound(final Bound pBound) {
		bound = pBound;
	}

	public Units getUnits() {
		return units;
	}

	public void setUnits(final Units pUnits) {
		units = pUnits;
	}

	@Override
	public String toString() {
		return "Timing [bound=" + bound + ", units=" + units + "]";
	}
	
}
