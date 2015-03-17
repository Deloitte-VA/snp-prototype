package com.github.jlgrock.snp.core.model;

public class Discernible {
	private Expression expression;

	public Expression getExpression() {
		return expression;
	}

	public void setExpression(Expression expression) {
		this.expression = expression;
	}

	@Override
	public String toString() {
		return "Discernible [expression=" + expression + "]";
	}
	
}
