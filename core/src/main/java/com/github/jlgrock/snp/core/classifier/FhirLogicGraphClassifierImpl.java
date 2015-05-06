package com.github.jlgrock.snp.core.classifier;

import gov.vha.isaac.logic.LogicGraph;

import java.util.UUID;

import org.jvnet.hk2.annotations.Service;

import com.github.jlgrock.snp.core.data.FhirLogicGraphBuilder;
import com.github.jlgrock.snp.core.model.xml.fhir.Condition;

/**
 * Replace Post Coordinated Expressions in Logic Graph with Classifier ID
 *
 */
@Service
public class FhirLogicGraphClassifierImpl implements LogicGraphClassifier<Condition> {

	@Override
	public UUID classify(final Condition pce) {

		//Set the expression from the
		FhirLogicGraphBuilder fhirLogicGraphBuilder = new FhirLogicGraphBuilder(pce);
		LogicGraph logicGraph = (LogicGraph)fhirLogicGraphBuilder;

		// TODO : call a service that takes a LogicGraph and returns a classifier ID
		//UUID classifierID = vaLogicService.classify(logicGraph);
		return UUID.randomUUID();
	}
	
}
