package com.github.jlgrock.snp.web.services;

import com.github.jlgrock.snp.core.classifier.PceClassifier;
import com.github.jlgrock.snp.core.data.ClassifiedPceStore;
import com.github.jlgrock.snp.core.domain.fhir.FhirEnvelope;

import javax.inject.Inject;

/**
 * Classifying service for FHIR PCEs.
 */
public class PceClassifierServiceFhirImpl implements PceClassifierService<FhirEnvelope> {

	private PceClassifier<FhirEnvelope> pceClassifier;
	private ClassifiedPceStore classPceStore;
	
	/**
	 * Constructor
	 * @param pceClassifierIn PCE Classifier
	 * @param classPceStoreIn Classified PCE store
	 */
	@Inject
	PceClassifierServiceFhirImpl(final PceClassifier<FhirEnvelope> pceClassifierIn,
			final ClassifiedPceStore classPceStoreIn) {
		this.pceClassifier = pceClassifierIn;
		this.classPceStore = classPceStoreIn;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void classifyAssertion(final FhirEnvelope fhirEnvelope) {
//		ClassifiedPce cAssertion = pceClassifier.classify(assertion);
//
//		// FIXME: need to capture patient id
//		Long patientId = 0L;
//		classPceStore.save(patientId , cAssertion);
	}

}
