package com.github.jlgrock.snp.core.data;

import com.github.jlgrock.snp.core.domain.ClassifiedAssertion;
import com.github.jlgrock.snp.core.domain.Patient;

/**
 * Store Assertions from LEGO document which have been replaced
 * with a classifier ID to the MongoDB
 *
 */
public class StoreClassifiedAssertion {
	private final ClassifiedAssertionRepository classifiedAssertionRepository;
	private final PatientRepository patientRepository;
	
	public StoreClassifiedAssertion(final ClassifiedAssertionRepository classifiedAssertionRepositoryIn,
			PatientRepository patientRepositoryIn) {
		classifiedAssertionRepository = classifiedAssertionRepositoryIn;
		patientRepository = patientRepositoryIn;
	}
	
	public void save(final Long patientId, final String classifierID) {
		ClassifiedAssertion classifiedAssertion = new ClassifiedAssertion();
		Patient patient = patientRepository.findOne(patientId);
		if(patient != null) {
			classifiedAssertionRepository.save(classifiedAssertion);
		}		
	}
	
}
