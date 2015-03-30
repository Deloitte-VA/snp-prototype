package com.github.jlgrock.snp.core.classifier;

import gov.vha.isaac.logic.LogicGraph;

import java.util.UUID;

import com.github.jlgrock.snp.core.data.LegoLogicGraphBuilder;
import com.github.jlgrock.snp.core.model.parser.Expression;

/**
 * Replace Post Coordinated Expressions in Logic Graph with Classifier ID
 *
 */
public class LogicGraphClassifierImpl implements LogicGraphClassifier {

	private LegoLogicGraphBuilder legoLogicGraphBuilder;

	public LogicGraphClassifierImpl(final LegoLogicGraphBuilder legoLogicGraphBuilderIn) {
		legoLogicGraphBuilder = legoLogicGraphBuilderIn;
	}

	@Override
	public UUID classify(final Expression expression) {
		//Set the expression from the
		legoLogicGraphBuilder.setExpression(expression);
		legoLogicGraphBuilder.create();
		LogicGraph logicGraph = legoLogicGraphBuilder.getLogicGraph();

		// TODO : call a service that takes a LogicGraph and returns a classifier ID
		//UUID classifierID = vaLogicService.classify(logicGraph);
		return UUID.randomUUID();
	}
	
}
