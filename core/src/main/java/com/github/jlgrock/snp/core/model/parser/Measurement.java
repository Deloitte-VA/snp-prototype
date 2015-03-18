package com.github.jlgrock.snp.core.model.parser;

/**
 * The Measurement class represents the measurement element in the LEGO XML document.
 *
 */
public class Measurement {
	private Units units;
	private Point point;
	private Bound bound;
	
	public Units getUnits() {
		return units;
	}
	
	public void setUnits(final Units pUnits) {
		units = pUnits;
	}
	
	public Point getPoint() {
		return point;
	}
	
	public void setPoint(final Point pPoint) {
		point = pPoint;
	}

	public Bound getBound() {
		return bound;
	}

	public void setBound(final Bound pBound) {
		bound = pBound;
	}

	@Override
	public String toString() {
		return "Measurement [units=" + units + ", point=" + point + ", bound=" + bound + "]";
	}
	
}
