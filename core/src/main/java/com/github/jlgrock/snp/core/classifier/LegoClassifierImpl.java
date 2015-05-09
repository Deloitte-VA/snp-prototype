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
public class LegoClassifierImpl implements PceClassifier<Assertion> {
	private LogicGraphClassifier<Expression> logicGraphClassifier;
	
	@Override
	public ClassifiedPce classify(final Assertion pce) {
		Expression expression = pce.getDiscernible().getExpression();
		ClassifiedPce classifiedAssertion = new ClassifiedPce();
		//check for complex expression since simple expression is not being classified
		if(expression.getRelation().size() > 0) {
			UUID uuid = logicGraphClassifier.classify(expression);
			classifiedAssertion.setUuid(uuid);
		}
		
		return classifiedAssertion;
	}

	public void setLogicGraphClassifier(final LogicGraphClassifier<Expression> logicGraphClassifierIn) {
		logicGraphClassifier = logicGraphClassifierIn;
	}
	
}
