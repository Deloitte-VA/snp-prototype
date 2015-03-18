package com.github.jlgrock.snp.core.model.parser;

/**
 * The Qualifier class represents the qualifier element in the LEGO XML document.
 *
 */
public class Qualifier {
	private Expression expression;

	public Expression getExpression() {
		return expression;
	}

	public void setExpression(final Expression pExpression) {
		expression = pExpression;
	}

	@Override
	public String toString() {
		return "Qualifier [expression=" + expression + "]";
	}
	
}
