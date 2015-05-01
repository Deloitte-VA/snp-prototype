package com.github.jlgrock.snp.core.classifier;

import java.util.UUID;

import com.github.jlgrock.snp.core.domain.lego.Expression;

/**
 * Classify Post Coordinated Expressions
 *
 */
public interface LogicGraphClassifier {

	/**
	 * replace Post Coordinated Expressions with a classifier ID
	 * 
	 * @param expression Expression
	 * @return UUID UUID
	 */
	UUID classify(Expression expression);
}
