package com.github.jlgrock.snp.core.model;

public class Bound {
	private Point lowerPoint;
	private Point upperPoint;
	private String lowerPointInclusive;
	private String upperPointInclusive;
	
	public Point getLowerPoint() {
		return lowerPoint;
	}

	public void setLowerPoint(Point lowerPoint) {
		this.lowerPoint = lowerPoint;
	}

	public Point getUpperPoint() {
		return upperPoint;
	}

	public void setUpperPoint(Point upperPoint) {
		this.upperPoint = upperPoint;
	}

	public String getLowerPointInclusive() {
		return lowerPointInclusive;
	}

	public void setLowerPointInclusive(String lowerPointInclusive) {
		this.lowerPointInclusive = lowerPointInclusive;
	}

	public String getUpperPointInclusive() {
		return upperPointInclusive;
	}

	public void setUpperPointInclusive(String upperPointInclusive) {
		this.upperPointInclusive = upperPointInclusive;
	}

	@Override
	public String toString() {
		return "Bound [lowerPoint=" + lowerPoint + ", upperPoint=" + upperPoint + ", lowerPointInclusive="
				+ lowerPointInclusive + ", upperPointInclusive=" + upperPointInclusive + "]";
	}
	
}
