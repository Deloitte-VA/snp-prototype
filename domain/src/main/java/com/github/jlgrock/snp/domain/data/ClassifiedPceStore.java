package com.github.jlgrock.snp.domain.data;

import com.github.jlgrock.snp.domain.types.ClassifiedPce;
import org.jvnet.hk2.annotations.Contract;

/**
 * Store Assertions from LEGO document which have been replaced
 * with a classifier ID
 *
 */
@Contract
public interface ClassifiedPceStore {

	/**
	 * saves the classified assertion to the database
	 * @param classifiedPce the assertion to store
	 */
	void save(final ClassifiedPce classifiedPce);
}
