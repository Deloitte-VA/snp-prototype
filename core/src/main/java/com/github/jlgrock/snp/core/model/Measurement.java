package com.github.jlgrock.snp.core.model;

public class Measurement {
	private Units units;
	private Point point;
	private Bound bound;
	
	public Units getUnits() {
		return units;
	}
	
	public void setUnits(Units units) {
		this.units = units;
	}
	
	public Point getPoint() {
		return point;
	}
	
	public void setPoint(Point point) {
		this.point = point;
	}

	public Bound getBound() {
		return bound;
	}

	public void setBound(Bound bound) {
		this.bound = bound;
	}

	@Override
	public String toString() {
		return "Measurement [units=" + units + ", point=" + point + ", bound=" + bound + "]";
	}
	
}
