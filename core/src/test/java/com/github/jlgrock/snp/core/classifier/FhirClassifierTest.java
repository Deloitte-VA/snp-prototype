package com.github.jlgrock.snp.core.classifier;

import static org.testng.Assert.assertNotNull;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.jlgrock.snp.core.domain.ClassifiedPce;
import com.github.jlgrock.snp.core.domain.fhir.Code;
import com.github.jlgrock.snp.core.domain.fhir.CodeableConcept;
import com.github.jlgrock.snp.core.domain.fhir.Coding;
import com.github.jlgrock.snp.core.domain.fhir.Condition;
import com.github.jlgrock.snp.core.domain.fhir.ConditionLocation;

public class FhirClassifierTest {
	private FhirClassifierImpl fhirClassifier;
	
	@BeforeClass
	public void setUp() {
		fhirClassifier = new FhirClassifierImpl();
		fhirClassifier.setLogicGraphClassifier(new FhirLogicGraphClassifierImpl());
	}
	
	@Test
	public void testClassify() {
		Condition condition = new Condition();
		ConditionLocation condLoc = new ConditionLocation();
		CodeableConcept cc = new CodeableConcept();
		Coding coding = new Coding();
		coding.setCode(new Code());
		cc.getCoding().add(coding);
		condLoc.setCode(cc);
		condition.getLocation().add(condLoc);
		condition.setCode(cc);
		
		ClassifiedPce classifiedAssertion = fhirClassifier.classify(condition);
		assertNotNull(classifiedAssertion.getUuid(), "pce is missing uuid");		
	}
}
