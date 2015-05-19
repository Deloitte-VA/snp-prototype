package com.github.jlgrock.snp.web.services;

import com.github.jlgrock.snp.core.classifier.PceClassifier;
import com.github.jlgrock.snp.core.data.ClassifiedPceStore;
import com.github.jlgrock.snp.core.domain.lego.LegoEnvelope;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;

/**
 * Classifying service for LEGO PCEs.
 */
@Service
public class PceClassifierServiceLegoImpl implements
		PceClassifierService<LegoEnvelope> {
	
	private PceClassifier<LegoEnvelope> pceClassifier;
	private ClassifiedPceStore classPceStore;
	
	/**
	 * Constructor
	 * @param pceClassifierIn PCE Classifier
	 * @param classPceStoreIn Classified PCE store
	 */
	@Inject
	protected PceClassifierServiceLegoImpl(final PceClassifier<LegoEnvelope> pceClassifierIn,
			final ClassifiedPceStore classPceStoreIn) {
		this.pceClassifier = pceClassifierIn;
		this.classPceStore = classPceStoreIn;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void classifyAssertion(final LegoEnvelope legoEnvelope) {
//		for (Assertion assertion : lego.getAssertion()) {
//			ClassifiedPce cAssertion = pceClassifier.classify(assertion);
//
//			// FIXME: need to capture patient id
//			Long patientId = 0L;
//			classPceStore.save(patientId , cAssertion);
//		}
	}
}
