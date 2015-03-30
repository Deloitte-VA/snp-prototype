package com.github.jlgrock.snp.core.classifier;

import org.jvnet.hk2.annotations.Service;

import com.github.jlgrock.snp.core.domain.ClassifiedAssertion;
import com.github.jlgrock.snp.core.model.parser.Assertion;
import com.github.jlgrock.snp.core.model.parser.Expression;

@Service
public class AssertionClassifierImpl implements AssertionClassifier {

	@Override
	public ClassifiedAssertion classify(Assertion assertion) throws IOException, ContradictionException {
		LogicGraph lg = buildLogicGraph(assertion);		
		LegoLogicGraphBuilder lgBuilder = new LegoLogicGraphBuilder(0, null, null);
		Expression expression = assertion.getDiscernible().getExpression();
		lgBuilder.setExpression(expression);
		LogicGraphClassifierImpl lgClassifier = new LogicGraphClassifierImpl(lgBuilder);
		UUID uuid = lgClassifier.classify(expression);
		ClassifiedAssertion classifiedAssertion = new ClassifiedAssertion();
		classifiedAssertion.setUuid(uuid);
		return classifiedAssertion;
	}

	public LogicGraph buildLogicGraph(Assertion assertion) throws IOException, ContradictionException {
		Expression expression = assertion.getDiscernible().getExpression();
		//TODO : sourceConceptSctid, isAboutUUID, destinationUUID
		LegoLogicGraphBuilder lgBuilder = new LegoLogicGraphBuilder(0, null, null);
		return lgBuilder.getLogicGraph();
	}
}
