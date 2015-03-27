package com.github.jlgrock.snp.core.classifier;

import gov.vha.isaac.logic.LogicGraph;

import java.util.UUID;

/**
 * Replace Post Coordinated Expressions in Logic Graph with Classifier ID
 *
 */
public class LogicGraphClassifierImpl implements LogicGraphClassifier {

	@Override
	public UUID classify(final LogicGraph logicGraph) {
		// TODO : call a service that takes a LogicGraph and returns a classifier ID
		//classifierID = vaLogicService.classify(logicGraph);
		return null;
	}
	
}
