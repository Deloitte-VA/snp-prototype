package com.github.jlgrock.snp.web.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.jlgrock.snp.core.classifier.PceClassifier;
import com.github.jlgrock.snp.core.data.ClassifiedAssertionStore;
import com.github.jlgrock.snp.core.domain.ClassifiedPce;
import com.github.jlgrock.snp.core.model.xml.lego.Assertion;

public class AssertionClassifierServiceImplTest {
	
	@Mock
	PceClassifier assertionClassifier;
	
	@Mock
	ClassifiedAssertionStore cAssertStore;
	
	@Mock
	Assertion assertion;
	
	@Mock
	ClassifiedPce cAssertion;

    @BeforeClass
    public void setUpTests() throws Exception {
        // Required to make this work on TestNG
        MockitoAnnotations.initMocks(this);
    }
    
	@Test
	public void testClassifyAssertion() {
		
		Mockito.when(assertionClassifier.classify(assertion)).thenReturn(cAssertion);
//		Mockito.verify(cAssertStore.save(Mockito.anyLong(), cAssertion));
		
		String expected = readFile("Assertion_Example_01.xml");
		PceClassifierServiceImpl classSvc = new PceClassifierServiceImpl(assertionClassifier, cAssertStore);
		classSvc.classifyAssertion(expected);
		
//		 TODO: need to add to test
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
