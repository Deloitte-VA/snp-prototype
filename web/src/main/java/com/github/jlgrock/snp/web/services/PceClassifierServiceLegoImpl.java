package com.github.jlgrock.snp.web.services;

import javax.inject.Inject;

import org.jvnet.hk2.annotations.Service;

import com.github.jlgrock.snp.core.classifier.PceClassifier;
import com.github.jlgrock.snp.core.data.ClassifiedPceStore;
import com.github.jlgrock.snp.core.domain.ClassifiedPce;
import com.github.jlgrock.snp.core.domain.lego.Assertion;
import com.github.jlgrock.snp.core.domain.lego.Lego;

/**
 * Classifying service for LEGO PCEs.
 */
@Service
public class PceClassifierServiceLegoImpl implements
		PceClassifierService<Lego> {
	
	private PceClassifier<Assertion> pceClassifier;
	private ClassifiedPceStore classPceStore;
	
	/**
	 * Constructor
	 * @param pceClassifierIn PCE Classifier
	 * @param classPceStoreIn Classified PCE store
	 */
	@Inject
	protected PceClassifierServiceLegoImpl(final PceClassifier<Assertion> pceClassifierIn,
			final ClassifiedPceStore classPceStoreIn) {
		this.pceClassifier = pceClassifierIn;
		this.classPceStore = classPceStoreIn;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void classifyAssertion(final Lego lego) {
		for (Assertion assertion : lego.getAssertion()) {
			ClassifiedPce cAssertion = pceClassifier.classify(assertion);

			// FIXME: need to capture patient id
			Long patientId = 0L;
			classPceStore.save(patientId , cAssertion);
		}
	}
}
