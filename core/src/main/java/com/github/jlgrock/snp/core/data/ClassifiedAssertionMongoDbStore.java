package com.github.jlgrock.snp.core.data;

import javax.inject.Inject;

import com.github.jlgrock.snp.core.domain.ClassifiedAssertion;
import com.github.jlgrock.snp.core.domain.Patient;

/**
 * Store Assertions from LEGO document which have been replaced
 * with a classifier ID to the MongoDB
 *
 */
public class ClassifiedAssertionMongoDbStore implements ClassifiedAssertionStore {
	private final ClassifiedAssertionRepository classifiedAssertionRepository;
	private final PatientRepository patientRepository;
	
	@Inject
	public ClassifiedAssertionMongoDbStore(final ClassifiedAssertionRepository classifiedAssertionRepositoryIn,
			PatientRepository patientRepositoryIn) {
		classifiedAssertionRepository = classifiedAssertionRepositoryIn;
		patientRepository = patientRepositoryIn;
	}
	
	public void save(final Long patientId, final ClassifiedAssertion classifiedAssertion) {
		Patient patient = patientRepository.findOneById(patientId);
		if(patient != null) {
			classifiedAssertionRepository.save(classifiedAssertion);
		}		
	}
	
}
