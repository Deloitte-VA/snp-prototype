package com.github.jlgrock.snp.web.services;

import com.github.jlgrock.snp.core.classifier.PceClassifier;
import com.github.jlgrock.snp.core.data.ClassifiedPceStore;
import com.github.jlgrock.snp.core.domain.ClassifiedPce;
import com.github.jlgrock.snp.core.domain.lego.Assertion;
import com.github.jlgrock.snp.core.domain.lego.Lego;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * Classifying service for PCEs.
 */
@Service
public class PceClassifierServiceImpl implements
		PceClassifierService<Lego> {
	
	PceClassifier<Assertion> pceClassifier;
	ClassifiedPceStore classPceStore;
	
	/**
	 * Contructor
	 * @param pceClassifierIn PCE Classifier
	 * @param classPceStoreIn Classified PCE store
	 */
	@Inject
	protected PceClassifierServiceImpl(final PceClassifier<Assertion> pceClassifierIn,
			final ClassifiedPceStore classPceStoreIn) {
		this.pceClassifier = pceClassifierIn;
		this.classPceStore = classPceStoreIn;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void classifyAssertion(final List<Lego> legos) {
    	for (Lego lego : legos) {
    		for (Assertion assertion : lego.getAssertion()) {
    			ClassifiedPce cAssertion = pceClassifier.classify(assertion);

    			// FIXME: need to capture patient id
    			Long patientId = 0L;
    			classPceStore.save(patientId , cAssertion);
    		}
    	}
	}
}
