package com.github.jlgrock.snp.web.services;

import javax.inject.Inject;

import com.github.jlgrock.snp.core.classifier.PceClassifier;
import com.github.jlgrock.snp.core.data.ClassifiedPceStore;
import com.github.jlgrock.snp.core.domain.ClassifiedPce;
import com.github.jlgrock.snp.core.domain.fhir.Condition;

/**
 * Classifying service for FHIR PCEs.
 */
public class PceClassifierServiceFhirImpl implements PceClassifierService<Condition> {

	private PceClassifier<Condition> pceClassifier;
	private ClassifiedPceStore classPceStore;
	
	/**
	 * Constructor
	 * @param pceClassifierIn PCE Classifier
	 * @param classPceStoreIn Classified PCE store
	 */
	@Inject
	PceClassifierServiceFhirImpl(final PceClassifier<Condition> pceClassifierIn,
			final ClassifiedPceStore classPceStoreIn) {
		this.pceClassifier = pceClassifierIn;
		this.classPceStore = classPceStoreIn;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void classifyAssertion(final Condition assertion) {
		ClassifiedPce cAssertion = pceClassifier.classify(assertion);

		// FIXME: need to capture patient id
		Long patientId = 0L;
		classPceStore.save(patientId , cAssertion);
	}

}
