package com.github.jlgrock.snp.web.controllers;

import java.io.InputStream;
import java.io.StringReader;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.io.input.ReaderInputStream;
import org.jvnet.hk2.annotations.Service;

import com.github.jlgrock.snp.core.classifier.AssertionClassifier;
import com.github.jlgrock.snp.core.data.ClassifiedAssertionStore;
import com.github.jlgrock.snp.core.domain.ClassifiedAssertion;
import com.github.jlgrock.snp.core.domain.lego.Assertion;
import com.github.jlgrock.snp.core.domain.lego.Lego;
import com.github.jlgrock.snp.core.domain.lego.LegoList;
import com.github.jlgrock.snp.core.parser.LegoXmlParser;

@Service
public class AssertionClassifierServiceImpl implements
		AssertionClassifierService<Lego> {
	
	AssertionClassifier assertClassifier;
	ClassifiedAssertionStore classAssertStore; 
	
	@Inject
	protected AssertionClassifierServiceImpl(AssertionClassifier assertClassifier, 
			ClassifiedAssertionStore classAssertStore) {
		this.assertClassifier = assertClassifier;
		this.classAssertStore = classAssertStore;
	}
	
	public void classifyAssertion(final String xml) {
		ReaderInputStream ris = new ReaderInputStream(new StringReader(xml));
//    	classifyAssertion(ris);
	}
	
//	public void classifyAssertion(final InputStream inStream) {
//		LegoList legoList = parseStream(inStream);
//    	List<Lego> legos = legoList.getLego();
//    	classifyAssertion(legos);
//	}
	
	public void classifyAssertion(final List<Lego> legos) {
    	for (Lego lego : legos) {
    		// FIXME: add loop
    		Assertion assertion = lego.getAssertion().get(0);
        	ClassifiedAssertion cAssertion = assertClassifier.classify(assertion);
        	
        	// FIXME: need to capture patient id
        	Long patientId = 0L;
			classAssertStore.save(patientId , cAssertion);
    	}
	}
	
//	public LegoList parseStream(final InputStream inStream) {
//		LegoXmlParser legoXmlParser = new LegoXmlParser();
//    	return legoXmlParser.parseDocument(inStream);
//	}
}
