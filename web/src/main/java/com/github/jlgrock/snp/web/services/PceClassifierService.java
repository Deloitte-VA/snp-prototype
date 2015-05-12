package com.github.jlgrock.snp.web.services;

import org.jvnet.hk2.annotations.Contract;

import java.util.List;

/**
 * Interface that should be implemented by assertion classifying services
 *
 * @param <T> Class that is handled by this service
 */
@Contract
public interface PceClassifierService<T> {
	
	/**
	 * Classifies a list of assertions
	 * @param assertions assertions to be classified
	 */
	void classifyAssertion(final List<T> assertions);
	
}
