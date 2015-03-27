package com.github.jlgrock.snp.core.classifier;

import com.github.jlgrock.snp.core.data.LegoLogicGraphBuilder;
import gov.vha.isaac.logic.LogicGraph;

import java.util.UUID;

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
	public UUID classify(final LogicGraph logicGraph) {
		String classifierID = "";

		//Set the expression from the
		legoLogicGraphBuilder.setExpression(expression);
		legoLogicGraphBuilder.create();
		legoLogicGraphBuilder.getLogicGraph();

		//TODO more here for Shane

		return null;
	}
	
}
