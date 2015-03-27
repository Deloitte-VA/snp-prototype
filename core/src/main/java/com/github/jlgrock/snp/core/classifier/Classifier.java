package com.github.jlgrock.snp.core.classifier;

import gov.vha.isaac.logic.LogicGraph;

import com.github.jlgrock.snp.core.domain.ClassifiedAssertion;

/**
 * Classify Post Coordinated Expressions
 *
 */
public interface Classifier {

	/**
	 * replace Post Coordinated Expressions with a classifier ID
	 * 
	 * @param logicGraph LogicGraph
	 * @return ClassifiedAssertion ClassifiedAssertion
	 */
	ClassifiedAssertion classify(LogicGraph logicGraph);
}
