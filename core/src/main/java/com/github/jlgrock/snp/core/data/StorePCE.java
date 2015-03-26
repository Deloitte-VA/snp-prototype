package com.github.jlgrock.snp.core.data;

import com.github.jlgrock.snp.core.domain.PCE;

/**
 * Store PCEs from LEGO document which have been replaced
 * with a classifier ID to the MongoDB
 *
 */
public class StorePCE {
	private final PceRepository repository;
		
	public StorePCE(final PceRepository repositoryIn) {
		repository = repositoryIn;
	}
	
	public void save(final String classifierID) {
		PCE pce = new PCE();
		pce.setId(classifierID);
		repository.save(pce);
	}
	
}
