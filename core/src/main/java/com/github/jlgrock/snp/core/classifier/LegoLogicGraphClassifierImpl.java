package com.github.jlgrock.snp.core.classifier;

import java.util.UUID;

import org.jvnet.hk2.annotations.Service;

import com.github.jlgrock.snp.core.domain.lego.Expression;

/**
 * Replace Post Coordinated Expressions in Logic Graph with Classifier ID
 *
 */
@Service
public class LegoLogicGraphClassifierImpl implements LogicGraphClassifier<Expression> {


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
