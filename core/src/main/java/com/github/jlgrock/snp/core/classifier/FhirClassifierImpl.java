package com.github.jlgrock.snp.core.classifier;

import java.util.UUID;

import org.jvnet.hk2.annotations.Service;

import com.github.jlgrock.snp.core.domain.ClassifiedPce;
import com.github.jlgrock.snp.core.domain.fhir.Condition;

/**
 * Classify a condition object with a complex expression
 */
@Service
public class FhirClassifierImpl implements PceClassifier<Condition> {
	private LogicGraphClassifier<Condition> logicGraphClassifier;
	
	@Override
	public ClassifiedPce classify(final Condition pce) {
		//TODO : check for complex expression since simple expression is not being classified
		// is this true for FHIR?
		UUID uuid = logicGraphClassifier.classify(pce);
		ClassifiedPce classifiedAssertion = new ClassifiedPce();
		classifiedAssertion.setUuid(uuid);
		
		return classifiedAssertion;
	}

	public void setLogicGraphClassifier(final LogicGraphClassifier<Condition> logicGraphClassifierIn) {
		logicGraphClassifier = logicGraphClassifierIn;
	}
	
}
