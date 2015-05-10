package com.github.jlgrock.snp.core.classifier;

import java.util.UUID;

import org.jvnet.hk2.annotations.Service;

import com.github.jlgrock.snp.core.domain.ClassifiedPce;
import com.github.jlgrock.snp.core.domain.lego.Assertion;
import com.github.jlgrock.snp.core.domain.lego.Expression;

/**
 * Classify an assertion object with a complex expression
 */
@Service
public class AssertionClassifierImpl implements AssertionClassifier {

	@Override
	public ClassifiedPce classify(final Assertion assertion) {
		LogicGraphClassifier<Expression> lgClassifier = new LegoLogicGraphClassifierImpl();
		Expression expression = assertion.getDiscernible().getExpression();
		ClassifiedPce classifiedAssertion = new ClassifiedPce();
		//check for complex expression since simple expression is not being classified
		if(expression.getRelation().size() > 0) {
			UUID uuid = lgClassifier.classify(expression);
			classifiedAssertion.setUuid(uuid);
		}
		
		return classifiedAssertion;
	}

}
