package com.github.jlgrock.snp.core.parser;

import static org.testng.Assert.assertEquals;

import java.io.InputStream;

import org.testng.annotations.Test;

import com.github.jlgrock.snp.core.model.parser.LegoList;

public class LegoXmlParserTest extends AbstractXmlParserTest {

	@Test
	public void testParserAudiologyObservables() throws Exception {
		InputStream xmlInput = getClass().getClassLoader().getResourceAsStream("Audiology OBSERVABLES.xml");
		LegoList legoList = new LegoXmlParser().parseDocument(xmlInput);
				
		String expected = readFile("Audiology OBSERVABLES.xml");
		String formatted = legoList.toXml();
		assertEquals(expected.trim(), formatted.trim());
	}
	
	@Test
	public void testParserEndocrineDiseasesHistory() throws Exception {
		InputStream xmlInput = getClass().getClassLoader().getResourceAsStream("Endocrine Diseases History.xml");
		LegoList legoList = new LegoXmlParser().parseDocument(xmlInput);
				
		String expected = readFile("Endocrine Diseases History.xml");
		String formatted = legoList.toXml();
		assertEquals(expected.trim(), formatted.trim());
	}
	
	@Test
	public void testParserHypertensionDisabliityBenefitsQuestionnaire() throws Exception {
		InputStream xmlInput = getClass().getClassLoader().getResourceAsStream("Hypertension Disability Benefits Questionnaire.xml");
		LegoList legoList = new LegoXmlParser().parseDocument(xmlInput);
				
		String expected = readFile("Hypertension Disability Benefits Questionnaire.xml");
		String formatted = legoList.toXml();
		assertEquals(expected.trim(), formatted.trim());
	}
	
}
