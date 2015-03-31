package com.github.jlgrock.snp.core.classifier;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.github.jlgrock.snp.core.domain.ClassifiedAssertion;
import com.github.jlgrock.snp.core.model.parser.Assertion;
import com.github.jlgrock.snp.core.model.parser.Destination;
import com.github.jlgrock.snp.core.model.parser.Discernible;
import com.github.jlgrock.snp.core.model.parser.Expression;
import com.github.jlgrock.snp.core.model.parser.Relation;

public class AssertionClassifierTest {
	
	@Test
	public void testClassifyComplexExpression() {
		Assertion assertion = new Assertion();
		Discernible discernible = new Discernible();
		Expression expression = new Expression();
				
		Relation relation = new Relation();
		Destination destination = new Destination();
		destination.setExpression(new Expression());
		relation.setDestination(destination);		
		List<Relation> relations = new ArrayList<Relation>();
		relations.add(relation);
		
		expression.setRelations(relations);			
		discernible.setExpression(expression);
		assertion.setDiscernible(discernible);			
		
		AssertionClassifier assertionClassifier = new AssertionClassifierImpl();
		ClassifiedAssertion classifiedAssertion = assertionClassifier.classify(assertion);
		assertNotNull(classifiedAssertion.getUuid(), "complex expression is missing uuid");		
	}
	
	@Test
	public void testClassifySimpleExpression() {
		Assertion assertion = new Assertion();
		Discernible discernible = new Discernible();
		Expression expression = new Expression();
		
		discernible.setExpression(expression);
		assertion.setDiscernible(discernible);
		
		AssertionClassifier assertionClassifier = new AssertionClassifierImpl();
		ClassifiedAssertion classifiedAssertion = assertionClassifier.classify(assertion);
		assertNull(classifiedAssertion.getUuid(), "simple expression does not need uuid");		
	}
}
