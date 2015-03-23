package com.github.jlgrock.snp.core.model.parser;

import com.google.common.base.MoreObjects;

/**
 * The Discernible class represents the discernible element in the LEGO XML document.
 *
 */
public class Discernible {
	private Expression expression;

	public Expression getExpression() {
		return expression;
	}

	public void setExpression(final Expression pExpression) {
		expression = pExpression;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
		.add("expression", expression)
		.toString();
	}
	
}
