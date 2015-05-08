package com.github.jlgrock.snp.core.data;

import com.github.jlgrock.snp.core.domain.ClassifiedPce;
import com.github.jlgrock.snp.core.domain.Patient;

import javax.inject.Inject;

/**
 * Store Assertions from LEGO document which have been replaced
 * with a classifier ID to the MongoDB
 *
 */
public class ClassifiedPceMongoDbStore implements ClassifiedPceStore {
	private final ClassifiedPceRepository classifiedPceRepository;
	private final PatientRepository patientRepository;

    /**
     * Create the assertion store
     * @param classifiedPceRepositoryIn the classifier repository, used for querying
     * @param patientRepositoryIn the patient repository, used for saving
     */
	@Inject
	public ClassifiedPceMongoDbStore(final ClassifiedPceRepository classifiedPceRepositoryIn,
                                     final PatientRepository patientRepositoryIn) {
		classifiedPceRepository = classifiedPceRepositoryIn;
		patientRepository = patientRepositoryIn;
	}

    @Override
	public void save(final Long patientId, final ClassifiedPce classifiedAssertion) {
		Patient patient = patientRepository.findOneById(patientId);
		if(patient != null) {
			classifiedPceRepository.save(classifiedAssertion);
		}		
	}
	
}
