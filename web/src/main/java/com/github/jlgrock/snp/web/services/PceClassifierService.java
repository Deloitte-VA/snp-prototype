package com.github.jlgrock.snp.web.services;

import org.jvnet.hk2.annotations.Contract;

/**
 * Interface that should be implemented by assertion classifying services
 *
 * @param <T> Class that is handled by this service
 */
@Contract
public interface PceClassifierService<T> {
	
	/**
	 * Classifies an assertion
	 * @param assertion assertion to be classified
	 */
//	void classifyAssertion(final T assertion);
	
}
