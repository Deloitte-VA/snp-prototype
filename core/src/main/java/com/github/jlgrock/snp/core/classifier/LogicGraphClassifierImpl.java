package com.github.jlgrock.snp.core.classifier;

import com.github.jlgrock.snp.core.domain.ClassifiedAssertion;
import gov.vha.isaac.logic.LogicGraph;
import gov.vha.isaac.logic.LogicGraphBuilder;

import java.util.UUID;

/**
 * Replace Post Coordinated Expressions in Logic Graph with Classifier ID
 *
 */
public class LogicGraphClassifierImpl implements LogicGraphClassifier {

	private LogicGraphBuilder logicGraphBuilder;

	public LogicGraphClassifierImpl(final LogicGraphBuilder logicGraphBuilderIn) {
		logicGraphBuilder = logicGraphBuilderIn;
	}

	@Override
	public UUID classify(final LogicGraph logicGraph) {
		String classifierID = "";
		// TODO : call a service that takes a LogicGraph and returns a classifier ID
		//classifierID = vaLogicService.classify(logicGraph);

		logicGraphBuilder.create();
		return transform(classifierID);
	}
	
}
