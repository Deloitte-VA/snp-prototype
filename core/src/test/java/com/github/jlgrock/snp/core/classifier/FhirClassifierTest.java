package com.github.jlgrock.snp.core.classifier;

import static org.testng.Assert.assertNotNull;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.jlgrock.snp.core.domain.ClassifiedPce;
import com.github.jlgrock.snp.core.model.xml.fhir.Code;
import com.github.jlgrock.snp.core.model.xml.fhir.Coding;
import com.github.jlgrock.snp.core.model.xml.fhir.Condition;
import com.github.jlgrock.snp.core.model.xml.fhir.Location;

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
		Location location = new Location();
		Code code = new Code();
		Coding coding = new Coding();
		coding.setCode(new Code());
		code.setCoding(coding);
		location.setCode(code);
		condition.setLocation(location);
		condition.setCode(code);
		
		ClassifiedPce classifiedAssertion = fhirClassifier.classify(condition);
		assertNotNull(classifiedAssertion.getUuid(), "pce is missing uuid");		
	}
}
