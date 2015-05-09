package com.github.jlgrock.snp.web.controllers;

import com.github.jlgrock.snp.core.classifier.PceClassifier;
import com.github.jlgrock.snp.core.data.ClassifiedPceStore;
import com.github.jlgrock.snp.core.domain.ClassifiedPce;
import com.github.jlgrock.snp.core.domain.lego.Assertion;
import com.github.jlgrock.snp.core.domain.lego.Lego;
import com.github.jlgrock.snp.core.domain.lego.LegoList;
import com.github.jlgrock.snp.core.parser.LegoXmlParser;
import org.apache.commons.io.input.ReaderInputStream;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;
import java.io.InputStream;
import java.io.StringReader;
import java.util.List;

@Service
public class PceClassifierServiceImpl implements
		PceClassifierService<Lego> {
	
	PceClassifier assertClassifier;
	ClassifiedPceStore classAssertStore;
	
	@Inject
	protected PceClassifierServiceImpl(final PceClassifier assertClassifierIn,
			final ClassifiedPceStore classAssertStoreIn) {
		this.assertClassifier = assertClassifierIn;
		this.classAssertStore = classAssertStoreIn;
	}
	
//	public void classifyAssertion(final String xml) {
//		ReaderInputStream ris = new ReaderInputStream(new StringReader(xml));
//    	classifyAssertion(ris);
//	}
	
//	public void classifyAssertion(final InputStream inStream) {
//		LegoList legoList = parseStream(inStream);
//    	List<Lego> legos = legoList.getLego();
//    	classifyAssertion(legos);
//	}
	
	public void classifyAssertion(final List<Lego> legos) {
    	for (Lego lego : legos) {
    		// FIXME: add loop
    		Assertion assertion = lego.getAssertion().get(0);
        	ClassifiedPce cAssertion = assertClassifier.classify(assertion);
        	
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
