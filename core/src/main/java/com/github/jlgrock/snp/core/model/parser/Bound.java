package com.github.jlgrock.snp.core.model.parser;

import com.google.common.base.MoreObjects;

/**
 * The Bound class represents the bound element in the LEGO XML document.
 *
 */
public class Bound {
	private Point lowerPoint;
	private Point upperPoint;
	private String lowerPointInclusive;
	private String upperPointInclusive;
	
	public Point getLowerPoint() {
		return lowerPoint;
	}

	public void setLowerPoint(final Point pLowerPoint) {
		lowerPoint = pLowerPoint;
	}

	public Point getUpperPoint() {
		return upperPoint;
	}

	public void setUpperPoint(final Point pUpperPoint) {
		upperPoint = pUpperPoint;
	}

	public String getLowerPointInclusive() {
		return lowerPointInclusive;
	}

	public void setLowerPointInclusive(final String pLowerPointInclusive) {
		lowerPointInclusive = pLowerPointInclusive;
	}

	public String getUpperPointInclusive() {
		return upperPointInclusive;
	}

	public void setUpperPointInclusive(final String pUpperPointInclusive) {
		upperPointInclusive = pUpperPointInclusive;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
		.add("lowerPoint", lowerPoint)
		.add("upperPoint", upperPoint)
		.add("lowerPointInclusive", lowerPointInclusive)
		.add("upperPointInclusive", upperPointInclusive)
		.toString();
	}
	
}
