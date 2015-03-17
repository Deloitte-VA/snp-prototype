package com.github.jlgrock.snp.core.parser;

import static org.testng.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.xml.stream.XMLStreamException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import org.testng.annotations.Test;

import com.github.jlgrock.snp.core.model.LegoList;

public class LegoXmlParserTest {

	@Test
	public void testParserAudiologyObservables() throws XMLStreamException, IOException, TransformerFactoryConfigurationError, TransformerException {
		InputStream xmlInput = getClass().getClassLoader().getResourceAsStream("Audiology OBSERVABLES.xml");
		LegoList legoList = new LegoXmlParser().parseDocument(xmlInput);
				
		String expected = readFile("Audiology OBSERVABLES.xml");
		String formatted = legoList.toXml();
		assertEquals(expected.trim(), formatted.trim());
	}
	
	@Test
	public void testParserEndocrineDiseasesHistory() throws XMLStreamException, IOException, TransformerFactoryConfigurationError, TransformerException {
		InputStream xmlInput = getClass().getClassLoader().getResourceAsStream("Endocrine Diseases History.xml");
		LegoList legoList = new LegoXmlParser().parseDocument(xmlInput);
				
		String expected = readFile("Endocrine Diseases History.xml");
		String formatted = legoList.toXml();
		assertEquals(expected.trim(), formatted.trim());
	}
	
	@Test
	public void testParserHypertensionDisabliityBenefitsQuestionnaire() throws XMLStreamException, IOException, TransformerFactoryConfigurationError, TransformerException {
		InputStream xmlInput = getClass().getClassLoader().getResourceAsStream("Hypertension Disability Benefits Questionnaire.xml");
		LegoList legoList = new LegoXmlParser().parseDocument(xmlInput);
				
		String expected = readFile("Hypertension Disability Benefits Questionnaire.xml");
		String formatted = legoList.toXml();
		assertEquals(expected.trim(), formatted.trim());
	}
	
	/**
	 * Prints the string content read from input stream
	 * @return content in file
	 */
	private String readFile(String xmlFile) {
		BufferedReader br = null;
		StringBuilder out = new StringBuilder();
		try {
			InputStream in = getClass().getClassLoader().getResourceAsStream(xmlFile);
	        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
	        String line;
	        while ((line = reader.readLine()) != null) {
	        	if(!"<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>".equals(line.trim())) {
	        		out.append(line.trim());
	        	}
	        }
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		 return out.toString();
	}
	
}
