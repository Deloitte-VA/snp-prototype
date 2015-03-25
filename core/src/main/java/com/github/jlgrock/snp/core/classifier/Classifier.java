package com.github.jlgrock.snp.core.classifier;

import gov.vha.isaac.logic.LogicGraph;

/**
 * Classify Post Coordinated Expressions
 *
 */
public interface Classifier {

	/**
	 * replace Post Coordinated Expressions with a classifier ID
	 * 
	 * @param logicGraph LogicGraph
	 * @return classifier ID
	 */
	String classify(LogicGraph logicGraph);
}
