package com.github.jlgrock.snp.web.controllers;

import java.io.InputStream;
import java.io.StringReader;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.io.input.ReaderInputStream;
import org.jvnet.hk2.annotations.Service;

import com.github.jlgrock.snp.core.classifier.PceClassifier;
import com.github.jlgrock.snp.core.data.ClassifiedAssertionStore;
import com.github.jlgrock.snp.core.domain.ClassifiedPce;
import com.github.jlgrock.snp.core.model.xml.lego.Assertion;
import com.github.jlgrock.snp.core.model.xml.lego.Lego;
import com.github.jlgrock.snp.core.model.xml.lego.LegoList;
import com.github.jlgrock.snp.core.parser.LegoXmlParser;

@Service
public class PceClassifierServiceImpl implements
		PceClassifierService {
	
	PceClassifier<Assertion> pceClassifier;
	ClassifiedAssertionStore classAssertStore; 
	
	@Inject
	protected PceClassifierServiceImpl(PceClassifier<Assertion> assertClassifier, 
			ClassifiedAssertionStore classAssertStore) {
		this.pceClassifier = assertClassifier;
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
        	ClassifiedPce cAssertion = pceClassifier.classify(assertion);
        	Long patientId = 0L;
			classAssertStore.save(patientId , cAssertion);
    	}
	}
}
