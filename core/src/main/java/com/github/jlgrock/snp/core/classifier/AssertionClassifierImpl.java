package com.github.jlgrock.snp.core.classifier;

import org.jvnet.hk2.annotations.Service;

import com.github.jlgrock.snp.core.domain.ClassifiedAssertion;
import com.github.jlgrock.snp.core.model.parser.Assertion;

@Service
public class AssertionClassifierImpl implements AssertionClassifier {

	@Override
	public ClassifiedAssertion classify(Assertion assertion) {
		// TODO : build logic graph
		//LogicGraph lg = buildLogicGraph(assertion);
		//LogicGraphClassifierImpl lgClassifier = new LogicGraphClassifierImpl();
		//UUID uuid = lgClassifier.classify(lg);
		//ClassifiedAssertion classifiedAssertion = (ClassifiedAssertion)assertion;
		//classifiedAssertion.setUuid(uuid);
		return null;
	}

}
