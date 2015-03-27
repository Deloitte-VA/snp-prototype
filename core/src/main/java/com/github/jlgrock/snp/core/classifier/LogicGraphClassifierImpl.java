package com.github.jlgrock.snp.core.classifier;

import gov.vha.isaac.logic.LogicGraph;

import com.github.jlgrock.snp.core.domain.ClassifiedAssertion;

/**
 * Replace Post Coordinated Expressions in Logic Graph with Classifier ID
 *
 */
public class LogicGraphClassifierImpl implements LogicGraphClassifier {

	@Override
	public ClassifiedAssertion classify(final LogicGraph logicGraph) {
		String classifierID = "";
		// TODO : call a service that takes a LogicGraph and returns a classifier ID
		//classifierID = vaLogicService.classify(logicGraph);
		return transform(classifierID);
	}
	
	public ClassifiedAssertion transform(String classifierID) {
		ClassifiedAssertion  classifiedAssertion = new ClassifiedAssertion();
		classifiedAssertion.setUuid(classifierID);
		return classifiedAssertion;
	}
	
}
