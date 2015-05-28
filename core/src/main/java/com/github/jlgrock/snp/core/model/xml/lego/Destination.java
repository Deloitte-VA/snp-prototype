package com.github.jlgrock.snp.core.model.xml.lego;

import com.google.common.base.MoreObjects;

/**
 * The Destination class represents the destination element in the LEGO XML document.
 *
 */
public class Destination {
	private Expression expression;
	private Measurement measurement;
	
	public Expression getExpression() {
		return expression;
	}
	
	public void setExpression(final Expression pExpression) {
		expression = pExpression;
	}	
	
	public Measurement getMeasurement() {
		return measurement;
	}

	public void setMeasurement(final Measurement pMeasurement) {
		measurement = pMeasurement;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
		.add("expression", expression)
		.add("measurement", measurement)
		.toString();
	}
	
}
