package com.github.jlgrock.snp.core.classifier;

import java.io.IOException;
import java.util.UUID;

import org.ihtsdo.otf.tcc.api.contradiction.ContradictionException;

import com.github.jlgrock.snp.core.domain.ClassifiedAssertion;
import com.github.jlgrock.snp.core.model.parser.Assertion;
import com.github.jlgrock.snp.core.model.parser.Expression;

public class AssertionClassifierImpl implements AssertionClassifier {

	@Override
	public ClassifiedAssertion classify(Assertion assertion) throws IOException, ContradictionException {
		LogicGraphClassifierImpl lgClassifier = new LogicGraphClassifierImpl();
		Expression expression = assertion.getDiscernible().getExpression();
		ClassifiedAssertion classifiedAssertion = new ClassifiedAssertion();
		//check for complex expression since simple expression is not being classified
		if(expression.getRelations().size() > 0) {
			UUID uuid = lgClassifier.classify(expression);
			classifiedAssertion.setUuid(uuid);
		}
		
		return classifiedAssertion;
	}

}
