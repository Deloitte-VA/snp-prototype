package com.github.jlgrock.snp.core.classifier;

import gov.vha.isaac.logic.LogicGraph;

import java.util.UUID;

/**
 * Classify Post Coordinated Expressions
 *
 */
public interface LogicGraphClassifier {

	/**
	 * replace Post Coordinated Expressions with a classifier ID
	 * 
	 * @param logicGraph LogicGraph
	 * @return UUID UUID
	 */
	UUID classify(LogicGraph logicGraph);
}
