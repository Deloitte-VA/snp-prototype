package com.github.jlgrock.snp.core.data;

import com.github.jlgrock.snp.core.domain.ClassifiedAssertion;

/**
 * Store Assertions from LEGO document which have been replaced
 * with a classifier ID
 *
 */
public interface ClassifiedAssertionStore {

	/**
	 * saves the classified assertion to the database
	 * @param patientId the patient id to save
	 * @param classifiedAssertion the assertion to store
	 */
	void save(final Long patientId, final ClassifiedAssertion classifiedAssertion);
}
