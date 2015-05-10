package com.github.jlgrock.snp.web.services;

import java.util.List;

import javax.inject.Inject;

import org.jvnet.hk2.annotations.Service;

import com.github.jlgrock.snp.core.classifier.PceClassifier;
import com.github.jlgrock.snp.core.data.ClassifiedPceStore;
import com.github.jlgrock.snp.core.domain.ClassifiedPce;
import com.github.jlgrock.snp.core.domain.lego.Assertion;
import com.github.jlgrock.snp.core.domain.lego.Lego;

@Service
public class PceClassifierServiceImpl implements
		PceClassifierService<Lego> {
	
	PceClassifier<Assertion> assertClassifier;
	ClassifiedPceStore classAssertStore;
	
	@Inject
	protected PceClassifierServiceImpl(final PceClassifier<Assertion> assertClassifierIn,
			final ClassifiedPceStore classAssertStoreIn) {
		this.assertClassifier = assertClassifierIn;
		this.classAssertStore = classAssertStoreIn;
	}
	
	public void classifyAssertion(final List<Lego> legos) {
    	for (Lego lego : legos) {
    		for (Assertion assertion : lego.getAssertion()) {
    			ClassifiedPce cAssertion = assertClassifier.classify(assertion);

    			// FIXME: need to capture patient id
    			Long patientId = 0L;
    			classAssertStore.save(patientId , cAssertion);
    		}
    	}
	}
}
