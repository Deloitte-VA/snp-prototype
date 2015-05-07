package com.github.jlgrock.snp.core.classifier;

import com.github.jlgrock.snp.core.model.xml.lego.Expression;

import java.util.UUID;

/**
 * Replace Post Coordinated Expressions in Logic Graph with Classifier ID
 *
 */
public class LogicGraphClassifierImpl implements LogicGraphClassifier {


	@Override
	public UUID classify(final Expression expression) {

		//Set the expression from the
		// LegoLogicGraphBuilder legoLogicGraphBuilder = new LegoLogicGraphBuilder(expression);
		// LogicGraph logicGraph = (LogicGraph)legoLogicGraphBuilder;

		// TODO : call a service that takes a LogicGraph and returns a classifier ID
		//UUID classifierID = vaLogicService.classify(logicGraph);
		return UUID.randomUUID();
	}
	
}
