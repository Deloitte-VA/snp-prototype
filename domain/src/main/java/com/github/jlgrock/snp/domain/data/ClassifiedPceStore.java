package com.github.jlgrock.snp.domain.data;

import com.github.jlgrock.snp.domain.types.ClassifiedPce;

/**
 * Store Assertions from LEGO document which have been replaced
 * with a classifier ID
 *
 */
public interface ClassifiedPceStore {

	/**
	 * saves the classified assertion to the database
	 * @param patientId the patient id to save
	 * @param classifiedAssertion the assertion to store
	 */
//	void save(final Long patientId, final ClassifiedPce classifiedAssertion);
	void save(final ClassifiedPce classifiedAssertion);
}
