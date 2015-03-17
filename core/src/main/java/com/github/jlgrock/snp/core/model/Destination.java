package com.github.jlgrock.snp.core.model;

public class Destination {
	private Expression expression;
	private Measurement measurement;
	
	public Expression getExpression() {
		return expression;
	}
	
	public void setExpression(Expression expression) {
		this.expression = expression;
	}	
	
	public Measurement getMeasurement() {
		return measurement;
	}

	public void setMeasurement(Measurement measurement) {
		this.measurement = measurement;
	}

	@Override
	public String toString() {
		return "Destination [expression=" + expression + ", measurement=" + measurement + "]";
	}
	
}
