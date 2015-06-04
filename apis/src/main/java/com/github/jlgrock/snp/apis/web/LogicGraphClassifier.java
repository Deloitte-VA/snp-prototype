package com.github.jlgrock.snp.apis.web;

import gov.vha.isaac.logic.LogicGraph;
import org.jvnet.hk2.annotations.Contract;

/**
 * Classify Post Coordinated Expressions, in logic graph form
 */
@Contract
public interface LogicGraphClassifier {

	/**
	 * replace Post Coordinated Expressions with a classifier ID
	 * 
	 * @param logicGraph The Post Coordinated Expression, in logic graph form
	 * @return the sequence number for this logic graph
	 */
	long classify(LogicGraph logicGraph);
}
