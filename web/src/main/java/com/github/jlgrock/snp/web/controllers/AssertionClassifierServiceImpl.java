package com.github.jlgrock.snp.web.controllers;

import java.io.InputStream;
import java.io.StringReader;
import java.util.List;

import org.apache.commons.io.input.ReaderInputStream;

import com.github.jlgrock.snp.core.classifier.AssertionClassifier;
import com.github.jlgrock.snp.core.data.ClassifiedAssertionStore;
import com.github.jlgrock.snp.core.domain.ClassifiedAssertion;
import com.github.jlgrock.snp.core.model.parser.Assertion;
import com.github.jlgrock.snp.core.model.parser.Lego;
import com.github.jlgrock.snp.core.model.parser.LegoList;
import com.github.jlgrock.snp.core.parser.LegoXmlParser;

public class AssertionClassifierServiceImpl implements
		AssertionClassifierService {
	
	AssertionClassifier assertClassifier;
	ClassifiedAssertionStore classAssertStore; 
	
	public AssertionClassifierServiceImpl(AssertionClassifier assertClassifier, 
			ClassifiedAssertionStore classAssertStore) {
		this.assertClassifier = assertClassifier;
		this.classAssertStore = classAssertStore;
	}
	
	public void classifyAssertion(final String xml) {
		ReaderInputStream ris = new ReaderInputStream(new StringReader(xml));
    	classifyAssertion(ris);
	}
	
	public void classifyAssertion(final InputStream inStream) {
		LegoXmlParser legoXmlParser = new LegoXmlParser();
    	LegoList legoList = legoXmlParser.parseDocument(inStream);
    	List<Lego> legos = legoList.getLegos();
    	classifyAssertion(legos);
	}
	
	private void classifyAssertion(final List<Lego> legos) {
    	for (Lego lego : legos) {
    		Assertion assertion = lego.getAssertion();
//    		System.out.println(assertion);
        	ClassifiedAssertion cAssertion = assertClassifier.classify(assertion);
        	Long patientId = 0L;
			classAssertStore.save(patientId , cAssertion);
    	}
	}
}
