package com.github.jlgrock.snp.core.data;

import com.github.jlgrock.snp.core.domain.ClassifiedAssertion;
import com.github.jlgrock.snp.core.model.parser.Lego;

import java.util.List;

/**
 * Store PCEs from LEGO document which have been replaced
 * with a classifier ID to the MongoDB
 *
 */
public class StoreClassifiedAssertion {
	private final ClassifiedAssertionRepository repository;
		
	public StoreClassifiedAssertion(final ClassifiedAssertionRepository repositoryIn) {
		repository = repositoryIn;
	}
	
	public void save(final List<Lego> legos, final String classifierID) {
		ClassifiedAssertion classifiedAssertion = new ClassifiedAssertion();
		repository.save(classifiedAssertion);
	}
	
}
