package com.github.jlgrock.snp.core.data;

import com.github.jlgrock.snp.core.domain.ClassifiedAssertion;

/**
 * Store Assertions from LEGO document which have been replaced
 * with a classifier ID
 *
 */
public interface ClassifiedAssertionStore {

	void save(final Long patientId, final ClassifiedAssertion classifiedAssertion);
}
