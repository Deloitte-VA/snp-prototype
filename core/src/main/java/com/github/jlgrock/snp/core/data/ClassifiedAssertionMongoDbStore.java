package com.github.jlgrock.snp.core.data;

import com.github.jlgrock.snp.core.domain.ClassifiedAssertion;
import com.github.jlgrock.snp.core.domain.Patient;

import javax.inject.Inject;

/**
 * Store Assertions from LEGO document which have been replaced
 * with a classifier ID to the MongoDB
 *
 */
public class ClassifiedAssertionMongoDbStore implements ClassifiedAssertionStore {
	private final ClassifiedAssertionRepository classifiedAssertionRepository;
	private final PatientRepository patientRepository;

    /**
     * Create the assertion store
     * @param classifiedAssertionRepositoryIn the classifier repository, used for querying
     * @param patientRepositoryIn the patient repository, used for saving
     */
	@Inject
	public ClassifiedAssertionMongoDbStore(final ClassifiedAssertionRepository classifiedAssertionRepositoryIn,
			final PatientRepository patientRepositoryIn) {
		classifiedAssertionRepository = classifiedAssertionRepositoryIn;
		patientRepository = patientRepositoryIn;
	}

    @Override
	public void save(final Long patientId, final ClassifiedAssertion classifiedAssertion) {
		Patient patient = patientRepository.findOneById(patientId);
		if(patient != null) {
			classifiedAssertionRepository.save(classifiedAssertion);
		}		
	}
	
}
